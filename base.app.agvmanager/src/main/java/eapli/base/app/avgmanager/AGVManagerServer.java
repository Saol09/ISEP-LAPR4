package eapli.base.app.avgmanager;


import eapli.base.agvManager.application.AGVManagerController;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class AGVManagerServer {
    static final int PORT = 3000;
    static final String TRUSTED_STORE = System.getProperty("user.dir") + "/certificates/serverAgvManager_J.jks";
    static final String KEYSTORE_PASS = "forgotten";
    static ServerSocket sock;

    public static void main(String[] args) throws Exception {

        SSLServerSocket sock = null;
        Socket cliSock;


        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sock = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }

        while (true) {
            cliSock = sock.accept();
            new Thread(new AGVManagerServerThread(cliSock)).start();

        }
    }
}


class AGVManagerServerThread implements Runnable {
    private final Socket s;
    private final AGVChangeStatusController controller = new AVGChangeStatusControllerImplementation();
    private final AGVChangeStatusMessageParser parser = new AGVChangeStatusMessageParser(controller);
    private final AGVManagerController avgController = new AGVManagerController();


    public AGVManagerServerThread(Socket cli_s) {
        s = cli_s;
    }

    public void run() {
        InetAddress clientIP;

        try {

            clientIP = this.s.getInetAddress();
            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() +
                    " connected");

            startFifo();
            DataInputStream sIn = new DataInputStream(this.s.getInputStream());
            DataOutputStream sOut = new DataOutputStream(this.s.getOutputStream());
            ObjectOutputStream sOutObj = null;
            ObjectInputStream sInObj = null;


            byte[] clientMessage = sIn.readNBytes(4);
            if (clientMessage[1] == 0) {
                System.out.println("Test code received (Code 0)");

                byte[] serverMessage = {(byte) 0, (byte) 2, (byte) 0, (byte) 0};

                System.out.println("Sending Acknowledge Signal (Code 2)");
                sOut.write(serverMessage);
                sOut.flush();
                System.out.println("Acknowledge Signal Sent (Code 2)");

                byte[] clientRequest = new byte[4];
                sIn.read(clientRequest, 0, 4);

                sOutObj = new ObjectOutputStream(this.s.getOutputStream());

                final AGVManagerRequest request = parser.parse(clientRequest[1], sOutObj, sInObj, sOut, sIn, clientRequest);
                request.execute();

                byte[] clientMessageEnd = sIn.readNBytes(4);
                if (clientMessageEnd[1] == 1) {
                    System.out.println("End Code received.");
                    byte[] serverMessageEnd = {(byte) 0, (byte) 2, (byte) 0, (byte) 0};
                    System.out.println("Sending Acknowledge Signal (Code 2)");
                    sOut.write(serverMessageEnd);
                    sOut.flush();
                    System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() +
                            " disconnected");
                } else {
                    System.out.println("Client Package Invalid.");
                }
            } else {
                System.out.println("Client Package Invalid.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.s.close();
            } catch (IOException e) {
                System.out.println("Socket was not closed..\n\n");
            }
            System.out.println("Socket Closed.\n\n");
        }
    }

    public void startFifo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                avgController.mainLoop();
            }
        }).start();
    }


}


