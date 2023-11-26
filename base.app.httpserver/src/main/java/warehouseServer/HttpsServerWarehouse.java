package warehouseServer;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Position;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.WarehousePlant;
import warehouseServer.application.CreateMatrixPlant;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;


/**
 *
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpsServerWarehouse {
    static private final String BASE_FOLDER="base.app.httpserver/src/main/java/warehouseServer/www";
    static private SSLServerSocket sock;

    public static void main(String args[]) throws Exception {
        SSLSocket cliSock;

        //vou buscar o agvmanager a partir de um client



        // ServerCommunicator.getplant();



        //___--_-----___--_-_-___-____-___-___-----_-_--_-_-_-







        if(args.length!=1) {
            System.out.println("Local port number required at the command line.");
            System.exit(1);
        }

        System.setProperty("javax.net.ssl.keyStore", "base.app.httpserver/src/main/java/warehouseServer/server2.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "forgotten");

        accessesCounter=0;
//        for(int i=0;i<candidatesNumber; i++) {
//            candidateName[i] = "Candidate " + i;
//            candidateVotes[i] = 0;
//        }

        try {
            SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sock = (SSLServerSocket) sslF.createServerSocket(Integer.parseInt(args[0]));
        }
        catch(IOException ex) {
            System.out.println("Server failed to open local port " + args[0]);
            System.exit(1);
        }

        while(true) {
            cliSock= (SSLSocket) sock.accept();
            HttpAjaxVotingRequest req=new HttpAjaxVotingRequest(cliSock, BASE_FOLDER);
            req.start();
            incAccessesCounter();
            TimeUnit.SECONDS.sleep(1);
        }
    }


    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static final int candidatesNumber = 4;
 //   private static final String[] candidateName = new String[candidatesNumber];
    private static final int[] candidateVotes = new int[candidatesNumber];
    private static int accessesCounter;

    private static synchronized void incAccessesCounter() { accessesCounter++; }
    private static final httpsController ctrl = new httpsController();
    private static final CreateMatrixPlant crea = new CreateMatrixPlant();

//    static int destinoy=2;
//    static int destinox=10;
//    static Position position = new Position(1,14);
    static boolean firstStop=true;

    public static synchronized String getVotesStandingInHTML() throws IOException, InterruptedException {


        Iterable<AGV> agvs= ctrl.getAGVStatus();
        WarehousePlant warehousePlant =ctrl.getPlant();



        String[][] plant = crea.createMatrix(warehousePlant);

        ctrl.makePlantWork(plant,firstStop);
        firstStop=false;

        StringBuilder textHtml = new StringBuilder("<table>");


        for (String[] strings : plant) {
            textHtml.append("<tr>");
            for (int j = 0; j < plant[0].length; j++) {
                if (strings[j] == null) {
                    textHtml.append("<td width=30px height=30px>").append(" ").append("</td>");
                } else {

                    if(strings[j].charAt(0) == 'D'){
                        textHtml.append("<th style=\"background-color:#FF8533FF\";>").append(strings[j]).append("</th>");
                    }else if (strings[j].charAt(0) == 'A'){
                        textHtml.append("<th style=\"background-color:#28ff6488\";>").append(strings[j]).append("</th>");
                    }else if (strings[j].charAt(0) == '0') {//obstaculo demostracao
                        textHtml.append("<th style=\"background-color:#89763459\";>")/*.append(/*what/*strings[j])*/.append("</th>");
                    }else{
                        textHtml.append("<th style=\"background-color:#34856734\";>").append(strings[j]).append("</th>");
                    }

                }
            }
            textHtml.append("</tr>");
        }
        textHtml.append("</table>");

        for (AGVDocks agvD:warehousePlant.getAGVDocks()) {
            int i=0;
            for (AGV agv:agvs) {
                if (agv.getAgvDocks().getId().equals(agvD.getId())){
                    textHtml.append("</br>").append(agvD.getId().getId()).append("--->").append(agv.getId()).append(": ").append(agv.getStatus());
                    i++;
                }
            }

            if (i!=1) {
                textHtml.append("</br>").append(agvD.getId().getId()).append("--->").append("no AGV Detected!");

            }

        }



        textHtml.append("</br>HTTP server accesses counter: ").append(accessesCounter);
        return textHtml.toString();
    }

    public static synchronized void castVote(String i) {
        int cN;
        try { cN=Integer.parseInt(i); }
        catch(NumberFormatException ne) { return; }
        cN--;
        if(cN >= 0 && cN < candidatesNumber) candidateVotes[cN]++;
    }



}
