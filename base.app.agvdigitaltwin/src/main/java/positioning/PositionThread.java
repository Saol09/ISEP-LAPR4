package positioning;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Position;
import eapli.base.agvConfiguration.domain.Speed;
import eapli.base.plantmanagment.domain.WarehousePlant;
import shared.SharedMemory;

import java.util.LinkedList;
import java.util.List;

public class PositionThread extends Thread{

    private Speed speed;

    private Position position;

    private SharedMemory sharedMemory;

    @Override
    public void run(){

        List<String> idList = sharedMemory.getIdList();

        List<LinkedList<Position>> routeList = sharedMemory.getRouteList();

        List<Position> posList = sharedMemory.getPosList();

        List<Speed> speedList = sharedMemory.getSpeedList();

        int index = 0;

        for (String id:idList){
            if (id.equals("AGV ID")){
                index = idList.indexOf(id);
            }
        }

        LinkedList<Position> route = routeList.get(index);
        position = posList.get(index); //position
        speed = speedList.get(index); //speed

        //direction
        for (int i = 0; i<speed.getVelocity();i++){
            route.removeFirst();

            if (i==speed.getVelocity()){
                position = route.getFirst();
                posList.get(0).setxPos(position.getxPos()); //change the last to the actual position
                posList.get(0).setyPos(position.getyPos());
            }
        }

        //save the changes to the shared memory

        sharedMemory.updatePosList(posList);
        sharedMemory.updateSpeedList(speedList);
        sharedMemory.changeRouteList(routeList);

        try{
            sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public class RoutePlanner{

        private AGV agv;



        private WarehousePlant plant;

        public RoutePlanner(){

        }

        public RoutePlanner(AGV agv, WarehousePlant plant) {
            this.agv = agv;
            this.plant = plant;
        }

        // algoritmo initial nao contem com obstaculos para já
        // pode precisar tb do agv id, tenho de decidir
        public LinkedList<Position> planRoute(Position initial,Position destino){

            LinkedList<Position> linkedList = new LinkedList<>();

            long x = plant.getLength();
            long y = plant.getWidth();

            int xDif = destino.getxPos()-initial.getxPos();
            int yDif = destino.getyPos()-initial.getyPos();


            if (yDif>0){
                int yi = initial.getyPos();

                for (int i =1; i<= yDif ; i++){
                    linkedList.add(initial);
                    yi++;
                    initial.setyPos(yi);
                }

            }
            if (xDif>0){
                int xi = initial.getxPos();
                for (int i =1; i<= xDif ; i++){
                    linkedList.add(initial);
                    xi++;
                    initial.setxPos(xi);
                }

            }

            if (yDif<0){
                int yi = initial.getyPos();

                for (int i =1; i<= yDif ; i++){
                    linkedList.add(initial);
                    yi--;
                    initial.setyPos(yi);
                }

            }
            if (xDif<0){
                int xi = initial.getxPos();
                for (int i =1; i<= xDif ; i++){
                    linkedList.add(initial);
                    xi--;
                    initial.setxPos(xi);
                }

            }
            return linkedList;
        }


    }


}
