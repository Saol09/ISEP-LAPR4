package warehouseServer.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.base.plantmanagment.repository.WarehousePlantRepository;

public class CreateMatrixPlant {


    public synchronized String[][] createMatrix(WarehousePlant warehousePlant){



        long square = warehousePlant.getSquare();
        int numLength = (int) (warehousePlant.getLength()/square);
        int numWidth = (int) (warehousePlant.getWidth()/square);

        String[][] plant=new String[numWidth][numLength];

        for (eapli.base.plantmanagment.domain.AGVDocks agvDock : warehousePlant.getAGVDocks()){

            int Bl =agvDock.getBegin().getlSquareb()-1;
            int El =agvDock.getEnd().getlSquare()-1;
            int Bw =agvDock.getBegin().getwSquareb()-1;
            int Dw =agvDock.getDepth().getwSquared()-1;
            for(int j=Bw;j<=Dw;j++) {
                for (int i=Bl;i<=El;i++){
                    plant[j][i] = agvDock.getId().getId();
                }
            }
        }


        for (eapli.base.plantmanagment.domain.Aisle aisle: warehousePlant.getAisle()){


            int Bl =aisle.getBegin().getlSquareb()-1;
            int El =aisle.getEnd().getlSquare()-1;
            int Bw =aisle.getBegin().getwSquareb()-1;
            int Dw =aisle.getDepth().getwSquared()-1;
            if (Bw > Dw){
                int i=Bw;
                Bw=Dw;
                Dw=i;
            }
            for(int j=Bw;j<=Dw;j++) {
                for (int i=Bl;i<=El;i++){

                    plant[j][i] = aisle.identity().toString();
                }
            }
        }


        return plant;

    }











}
