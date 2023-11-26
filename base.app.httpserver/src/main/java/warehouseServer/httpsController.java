package warehouseServer;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Position;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.Aisle;
import eapli.base.plantmanagment.domain.Rows;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.base.plantmanagment.repository.WarehousePlantRepository;
import eapli.base.product.domain.Product;
import eapli.base.product.domain.ProductLocation;
import eapli.base.product.repository.ProductRepository;

import java.util.ArrayList;

public class httpsController {
    public AGVConfigurationRepository agvConfigurationRepository = PersistenceContext.repositories().agvConfigurationRepository();

    public WarehousePlantRepository warehousePlantRepository = PersistenceContext.repositories().warehousePlantRepository();

    public ProductRepository productRepository = PersistenceContext.repositories().productRepository();

    public synchronized Iterable<AGV> getAGVStatus() {

        Iterable<AGV> agvs = agvConfigurationRepository.findAll();


        return agvs;


    }

    public synchronized WarehousePlant getPlant() {

        WarehousePlant plant = warehousePlantRepository.findAll().iterator().next();


        return plant;


    }

    Position positionBegin;
    Position positionDestiny;
    ArrayList<Position> listB= new ArrayList<>();
    ArrayList<Position> listD= new ArrayList<>();
    ArrayList<String> agvID=new ArrayList<>();

    public synchronized void makePlantWork(String[][] plant, boolean firstStop) {

        Iterable<AGV> agvs = agvConfigurationRepository.findOccupiedTask();

        for (AGV agv : agvs) {

            if (firstStop) {
                String idProduct = agv.getTask().toString();
                Product product = productRepository.findByID(Long.parseLong(idProduct));
                AGVDocks agvDocks = agv.getAgvDocks();
                String id = agvDocks.getId().getId();
                ProductLocation location = product.getProductLocation();
                WarehousePlant warehousePlant = warehousePlantRepository.findAll().iterator().next();

                for (Aisle aisle : warehousePlant.getAisle()) {
                    if (location.getProductAisle() == aisle.identity()) {
                        for (Rows rows : aisle.getRows()) {
                            if (location.getProductRow() == rows.identity()) {
                                int assess;
                                //if (location.getProductShelf() == rows.getShelves()) {
                                if (aisle.getAccessibility().getAccess().charAt(1) == '-') {
                                    assess = -1;
                                } else {
                                    assess = 1;
                                }

                                int sh = rows.getShelves();

                                int shift = (rows.getEnd().getlSquare() - rows.getBegin().getlSquareb()) / sh;
                                int x=rows.getBegin().getlSquareb();
                                int y=rows.getEnd().getwSquare();


                                positionDestiny = new Position(rows.getEnd().getwSquare()-1 + assess,rows.getBegin().getlSquareb()-1 );//isto pode estarmalllllll

                                listD.add(positionDestiny);
                                // }


                            }
                        }
                    }
                }
                agvID.add(agv.getId().getId());
                for (int i = 0; i < plant.length; i++) {
                    for (int j = 0; j < plant[0].length; j++) {
                        if (id.equals(plant[i][j])) {
                            positionBegin = new Position(i, j+1);
                            listB.add(positionBegin);
                        }
                    }
                }
            }



        }

        for (Position p:listD) {
            plant[p.getxPos()][p.getyPos()]="0";
        }

//        for (int i=0;i<listB.size();i++) {
//            plant[listB.get(i).getxPos()][listB.get(i).getyPos()]=agvs.iterator().next().getId().getId();
//        }

        for (int i=0;i<listB.size();i++){
            Position agvPos=listB.get(i);
            Position agvDes=listD.get(i);


            if(agvDes.getxPos()==agvPos.getxPos()&&agvDes.getyPos()==agvPos.getyPos()){
                agvDes.setxPos(0);
                agvDes.setyPos(0);
            }


            if (agvPos.getxPos() < agvDes.getxPos() && plant[agvPos.getyPos()][agvPos.getxPos()+1]==null){
                agvPos.setxPos(agvPos.getxPos()+1);

            }else if(agvPos.getxPos() > agvDes.getxPos() && plant[agvPos.getyPos()][agvPos.getxPos()-1]==null){

                agvPos.setxPos(agvPos.getxPos()-1);
            }else if(agvPos.getyPos() < agvDes.getyPos() && plant[agvPos.getyPos()+1][agvPos.getxPos()]==null){
                agvPos.setyPos(agvPos.getyPos()+1);

            }else if(agvPos.getyPos() > agvDes.getyPos() && plant[agvPos.getyPos()-1][agvPos.getxPos()]==null){
                agvPos.setyPos(agvPos.getyPos()-1);
            }

            plant[listB.get(i).getxPos()][listB.get(i).getyPos()]=agvID.get(i);


        }


//        for (String[] string:plant) {
//            System.out.println(string.toString());
//        }

    }

}
