package eapli.base.plantmanagment.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Plant builder.
 */
public class PlantBuilder {


    /**
     * Build new plant warehouse plant.
     *
     * @param listOfvariablesJson the list ofvariables json
     * @return the warehouse plant
     */
    public WarehousePlant buildNewPlant(ArrayList<Object> listOfvariablesJson){

        ArrayList<Object> asiles= (ArrayList<Object>) listOfvariablesJson.get(5);
        ArrayList<Object> agvDock=(ArrayList<Object>) listOfvariablesJson.get(6);
        List<Aisle> aislesList= new ArrayList<>();

        List<AGVDocks> agvDocksList=new ArrayList<>();
        for(int i =0;i<asiles.size();i++){
            ArrayList<Object> rows= (ArrayList<Object>) asiles.get(i+3);

            List<Rows> rowsList= new ArrayList<>();
            for(int j =0;j<rows.size();j++){
                RowsIDs rowsIDs =new RowsIDs(Math.toIntExact((Long) rows.get(j)),Math.toIntExact((Long) asiles.get(i)));
                Rows rows1 = new Rows(rowsIDs,(ArrayList<Long>) rows.get(j+1), Math.toIntExact((Long) rows.get(j + 2)));
                j=j+2;
                rowsList.add(rows1);
            }

            Aisle aisle = new Aisle(Math.toIntExact((Long) asiles.get(i)),
                                    (ArrayList<Long>) asiles.get(i+1),
                                    new Accessibility((String) asiles.get(i+2)) ,rowsList);
            aislesList.add(aisle);
            i=i+3;
        }

        for (int i=0;i<agvDock.size();i++){
            AGVDocks agvDocks = new AGVDocks(new IDagvDocks((String) agvDock.get(i)),(ArrayList<Long>) agvDock.get(i+1),new Accessibility((String) agvDock.get(i+2)));
            agvDocksList.add(agvDocks);
            i=i+2;
        }



        WarehousePlant warehousePlant=new WarehousePlant((String) listOfvariablesJson.get(0),
                                                        (Long) listOfvariablesJson.get(1),
                                                        (Long) listOfvariablesJson.get(2),
                                                        (Long) listOfvariablesJson.get(3),
                                                        new Unit((String) listOfvariablesJson.get(4)),aislesList,
                                                        agvDocksList);

        return warehousePlant;

    }


}
