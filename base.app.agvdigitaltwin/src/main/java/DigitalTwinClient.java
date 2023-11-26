import eapli.base.utils.TCPMessageUtils;


import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class DigitalTwinClient {


    static final int TWINPORT = 4995;
    static final int AGVPORT = 3000;

    static final String TWINTRUSTED_STORE = System.getProperty("user.dir") + "/certificates/serverDigitalTwin_J.jks";
    static final String AGVTRUSTED_STORE = System.getProperty("user.dir") + "/certificates/serverAgvManager_J.jks";

    static final String KEYSTORE_PASS = "forgotten";

    private static InetAddress serverIP;



        // tem de ser 3 4 ou 5.   O 3 é para mudar para free, o 4 para Charging e o 5 para doing task
        public static boolean changeAGVStatus (String avgId,int messageCode){

            SSLSocket sock = null;
            Socket cliSock;


            // Trust these certificates provided by authorized clients
            System.setProperty("javax.net.ssl.trustStore", AGVTRUSTED_STORE);
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            // Use this certificate and private key as server certificate
            System.setProperty("javax.net.ssl.keyStore", AGVTRUSTED_STORE);
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

            SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();


            try {
                try {
                    serverIP = InetAddress.getByName("localhost");
                } catch (UnknownHostException ex) {
                    System.out.println("Invalid server specified: " + serverIP);
                    System.exit(1);
                }
                try {
                    sock = (SSLSocket) sf.createSocket(serverIP, AGVPORT);

                } catch (IOException ex) {
                    System.out.println("Failed to establish TCP connection");
                    System.exit(1);
                }
                System.out.println("Connected to: " + serverIP + " through port:" + 3000);


                try {

                    sock.startHandshake();

                    DataOutputStream sOutData = new DataOutputStream(sock.getOutputStream());
                    DataInputStream sInData = new DataInputStream(sock.getInputStream());

                    // Test signal and waits for response with code 2 from server
                    byte[] clientMessage = {(byte) 0, (byte) 0, (byte) 0, (byte) 0};
                    sOutData.write(clientMessage);
                    sOutData.flush();

                    byte[] serverResponse = sInData.readNBytes(4);
                    // Checking if the code 2 was sent by the server
                    if (serverResponse[1] == 2) {

                        TCPMessageUtils.writeMessageWithData((byte) messageCode, avgId, sOutData);

                        // Sending End request to the server
                        byte[] endRequest = {(byte) 0, (byte) 1, (byte) 0, (byte) 0};
                        sOutData.write(endRequest);
                        sOutData.flush();

                        byte[] serverMessageEnd = sInData.readNBytes(4);
                        if (serverMessageEnd[1] == 2) {
                            sock.close();
                        }

                        return true;

                    } else {
                        System.out.println("Did not receive the ACK code");
                    }
                } catch (IOException e) {
                    System.out.println("Failed while trying to send info from the server");
                } finally {
                    try {
                        sock.close();
                    } catch (IOException e) {
                        System.out.println("Failed while trying to close socket");
                    }
                }
                return true;


            } catch (Exception e) {
                System.out.println("Server is down");
                System.out.println(e.getMessage());
                return false;
            }


        }




    public static boolean changeAGVTask (String avgId,int messageCode, String task){

        SSLSocket sock = null;
        Socket cliSock;


        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TWINTRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", TWINTRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();


        try {
            try {
                serverIP = InetAddress.getByName("localhost");
            } catch (UnknownHostException ex) {
                System.out.println("Invalid server specified: " + serverIP);
                System.exit(1);
            }
            try {
                sock = (SSLSocket) sf.createSocket(serverIP, TWINPORT);
            } catch (IOException ex) {
                System.out.println("Failed to establish TCP connection");
                System.exit(1);
            }
            System.out.println("Connected to: " + serverIP + " through port:" + 4995);



            try {

                sock.startHandshake();


                DataOutputStream sOutData = new DataOutputStream(sock.getOutputStream());
                DataInputStream sInData = new DataInputStream(sock.getInputStream());


                // Test signal and waits for response with code 2 from server
                byte[] clientMessage = {(byte) 0, (byte) 0, (byte) 0, (byte) 0};
                sOutData.write(clientMessage);
                sOutData.flush();

                byte[] serverResponse = sInData.readNBytes(4);
                // Checking if the code 2 was sent by the server
                if (serverResponse[1] == 2) {

                    TCPMessageUtils.writeMessageWithData((byte) messageCode, avgId, sOutData);
                    Thread.sleep(1000);
                    TCPMessageUtils.writeMessageWithData((byte) 3, task, sOutData);

                    // Sending End request to the server
                    byte[] endRequest = {(byte) 0, (byte) 1, (byte) 0, (byte) 0};
                    sOutData.write(endRequest);
                    sOutData.flush();

                    byte[] serverMessageEnd = sInData.readNBytes(4);
                    if (serverMessageEnd[1] == 2) {
                        sock.close();
                    } else {
                        System.out.println("Did not receive the ACK code");
                    }

                    return true;

                } else {
                   System.out.println("Did not receive the ACK code");
                }
            } catch (IOException e) {
                System.out.println("Failed while trying to send info from the server");
            } finally {
                try {
                    sock.close();
                } catch (IOException e) {
                    System.out.println("Failed while trying to close socket");
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("Server is down");
            System.out.println(e.getMessage());
            return false;
        }

    }


}







