package eapli.base.plantmanagment.application;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;


/**
 * The type Plant json import.
 */
public class PlantJsonImport {


    /**
     * Organize plant array list.
     *
     * @param filename the filename
     * @return the array list
     */
    public ArrayList<Object> OrganizePlant(final String filename) {
        ArrayList<Object> listPlant = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(".\\files\\" + filename + ".json");

            Object obj = jsonParser.parse(reader);
            JSONObject houseJsonObj = (JSONObject) obj;




            //TODO initial parts
            listPlant.add(houseJsonObj.get("Warehouse"));
            listPlant.add(houseJsonObj.get("Length"));
            listPlant.add(houseJsonObj.get("Width"));
            listPlant.add(houseJsonObj.get("Square"));
            listPlant.add(houseJsonObj.get("Unit"));
            //System.out.println(title+"\n"+lengthT+"\n"+widthT+"\n"+SquareT+"\n"+Unit); //TODO IMPORTANT TEST
            //TODO PART OF AI

            JSONArray arrayAisles = (JSONArray) houseJsonObj.get("Aisles");

            ArrayList<Object> listAisles =new ArrayList<>();

            for (int i = 0; i < arrayAisles.size(); i++) {
                JSONObject aisles = (JSONObject) arrayAisles.get(i);
                listAisles.add(aisles.get("Id"));

                ArrayList<Long> beginEndDepthList = beginEndDepthMethod(aisles);

                listAisles.add(beginEndDepthList);

                //System.out.println(id+"\n"+accessibility+"\n");//TODO IMPORTANT TEST
//                for (int j = 0;j<beginEndDepthList.size();j++){
//                    listAisles.add(beginEndDepthList.get(j));
//                }
                listAisles.add(aisles.get("accessibility"));
               //TODO ROWS OF AISLES
                JSONArray arrayRows = (JSONArray) aisles.get("rows");

                ArrayList<Object> listRow =new ArrayList<>();
                for (int j = 0; j < arrayRows.size(); j++) {
                    JSONObject rows = (JSONObject) arrayRows.get(j);
                    listRow.add((rows.get("Id")));
                    ArrayList<Long> listRows=beginEndDepthMethod(rows);

                    listRow.add(listRows);
                    //.out.println(idRows+"\n"+shelves+"\n"); //TODO IMPORTANT TEST
//                    for (int l = 0;l<listRows.size();l++){
//                        listRow.add((listRows.get(l)));
//                    }
                    listRow.add(rows.get("shelves"));

                }
                listAisles.add(listRow);
            }
            listPlant.add(listAisles);
            JSONArray arrayAGVDocks = (JSONArray) houseJsonObj.get("AGVDocks");
            ArrayList<Object> listDocks =new ArrayList<>();
            for (int i = 0; i < arrayAGVDocks.size(); i++) {
                JSONObject agvDocks = (JSONObject) arrayAGVDocks.get(i);
                listDocks.add(agvDocks.get("Id"));
                ArrayList<Long> listAgvDocks=beginEndDepthMethod(agvDocks);
                listDocks.add(listAgvDocks);
                listDocks.add(agvDocks.get("accessibility"));
                //System.out.println(id+"\n"+accessibility+"\n"); //TODO IMPORTANT TEST
//                for (int j = 0;j<listAgvDocks.size();j++){
//                    listPlant.add((listAgvDocks.get(j)));
//                }
            }
            listPlant.add(listDocks);


        } catch (IOException | ParseException e){

            e.printStackTrace();
        }

        return listPlant;

    }


    private ArrayList<Long> beginEndDepthMethod(JSONObject arrayMethod){
        ArrayList<Long> listSquares = new ArrayList<>();
        //TODO PART OF BEGIN IN AISLES
        JSONObject beginArray = (JSONObject) arrayMethod.get("begin");
        long lSquareBegin = (long) beginArray.get("lsquare");
        long wSquareBegin = (long) beginArray.get("wsquare");
        listSquares.add(lSquareBegin);
        listSquares.add(wSquareBegin);
        //TODO PART OF END IN AISLES
        JSONObject endArray = (JSONObject) arrayMethod.get("end");
        long lSquareEnd = (long) endArray.get("lsquare");
        long wSquareEnd = (long) endArray.get("wsquare");
        listSquares.add(lSquareEnd);
        listSquares.add(wSquareEnd);

        //TODO PART OF DEPTH IN AISLES
        if (arrayMethod.get("depth") != null){
            JSONObject depthArray = (JSONObject) arrayMethod.get("depth");
            long lSquareDepth = (long) depthArray.get("lsquare");
            long wSquareDepth = (long) depthArray.get("wsquare");
            listSquares.add(lSquareDepth);
            listSquares.add(wSquareDepth);
        }






        return listSquares;

    }

}
