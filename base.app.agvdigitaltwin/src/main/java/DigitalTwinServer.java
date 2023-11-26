import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Id;
import eapli.base.agvConfiguration.domain.Task;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.utils.TCPMessageUtils;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class DigitalTwinServer {

    static final int PORT = 4995;
    static final String TRUSTED_STORE = System.getProperty("user.dir") + "/certificates/serverDigitalTwin_J.jks";
    static final String KEYSTORE_PASS = "forgotten";



    static void mainCaller() throws Exception {
       main(null);
    }




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
            new Thread(new DigitalTwinThread(cliSock)).start();
        }
    }


}



class DigitalTwinThread implements Runnable {

    private final Socket s;
    private final AGVConfigurationRepository agvConfigurationRepository = PersistenceContext.repositories().agvConfigurationRepository();


    public DigitalTwinThread(Socket cli_s) {
        s = cli_s;
    }

    public void run() {

        InetAddress clientIP;

        try {
            clientIP = this.s.getInetAddress();
            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() +
                    " connected");
            DataInputStream sIn = new DataInputStream(this.s.getInputStream());
            DataOutputStream sOut = new DataOutputStream(this.s.getOutputStream());

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



                /*Changing the Tasks*/
                if (clientRequest[1] == 2) {

                    String messageTemp1 = TCPMessageUtils.getDataFromMessage(clientRequest, sIn);
                    Thread.sleep(1000);
                    byte[] clientRequest2 = new byte[4];
                    sIn.read(clientRequest2, 0, 4);
                    String messageTemp2 = TCPMessageUtils.getDataFromMessage(clientRequest2, sIn);
                    System.out.println();
                    System.out.println();
                    System.out.println();


                    System.out.println(messageTemp1);
                    System.out.println(messageTemp2);

                    AGV agv = agvConfigurationRepository.findByAGVId(new Id(messageTemp1));
                    Task task = new Task(messageTemp2);
                    agv.changeTaskTo(task);
                    agvConfigurationRepository.save(agv);
                }


                byte[] clientMessageEnd = sIn.readNBytes(4);
                if (clientMessageEnd[1] == 1) {
                    System.out.println("End Code received.");
                    byte[] serverMessageEnd = {(byte) 0, (byte) 2, (byte) 0, (byte) 0};
                    System.out.println("Sending Acknowledge Signal (Code 2)");
                    sOut.write(serverMessageEnd);
                    sOut.flush();
                    System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() +
                            " disconnected");
                }  else {
                System.out.println("Client Package Invalid.");
            }

            } else {
                System.out.println("Client Package Invalid.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                this.s.close();
            } catch (IOException e) {
                System.out.println("Socket was not closed..\n\n");
            }
            System.out.println("Socket Closed.\n\n");
        }
    }

}