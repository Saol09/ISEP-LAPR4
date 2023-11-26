//package warehouseServer;
//
//import eapli.base.utils.TCPMessageUtils;
//
//import java.io.*;
//import java.net.*;
//
//
//public class ServerCommunicator {
//	static private Socket sock;
//	static private InetAddress serverIP;
//	static private int serverPort;
//	static private DataOutputStream sOut;
//	static private DataInputStream sIn;
//
//
//    public static String[][] getplant(){
//
//
//
//        try { serverIP = InetAddress.getByName("127.0.0.1"); }
//        catch(UnknownHostException ex) {
//            System.out.println("Invalid SERVER-ADDRESS.");
//            System.exit(1);
//        }
//
//        try { serverPort = Integer.parseInt("3000"); }
//        catch(NumberFormatException ex) {
//            System.out.println("Invalid SERVER-PORT.");
//            System.exit(1);
//        }
//
//        System.out.println("Connecting to https://" + "127.0.0.1" + ":" + serverPort + "/");
//
//        try { sock = new Socket(serverIP, serverPort); }
//        catch(IOException ex) {
//            System.out.println("Failed to connect to provided SERVER-ADDRESS and SERVER-PORT.");
//            System.out.println("Application aborted.");
//            System.exit(1);
//        }
//
//        try {
//            sOut = new DataOutputStream(sock.getOutputStream());
//            sIn = new DataInputStream(sock.getInputStream());
//        }
//        catch(IOException ex) {
//            System.out.println("Error accessing socket's streams. Aborted.");
//            try { sock.close(); } catch(IOException ex2) { System.out.println("Error closing socket."); }
//            System.out.println("Application aborted.");
//            System.exit(1);
//        }
//
//
//        String[][] plant = ;
//
//        try {
//            sock.close();
//            return plant;
//        }
//        catch(IOException ex2) {
//            System.out.println("Error closing socket.");
//        }
//
//
//
//
//
//
//
//    }