package simulationEngine;

import eapli.base.agvConfiguration.domain.Position;
import eapli.base.plantmanagment.domain.WarehousePlant;
import shared.SharedMemory;

import java.util.List;

public class SimulationEngineThread extends Thread{

    @Override
    public void run(){

        SharedMemory sharedMemory = new SharedMemory();

        List<Position> posList = sharedMemory.getPosList();

        WarehousePlant plant = sharedMemory.getPlant();

        int x = (int)plant.getLength();
        int y = (int)plant.getWidth();

        int[][] simulation = new int[x][y];

        for (int i = 0; i<x; i++){
            for (int j=0; j<y; j++){
                simulation[x][y] = 0;
                for (Position p : posList){
                    if (p.getxPos()==x && p.getyPos()==y)
                        simulation[x][y] = 1;
                }
            }
        }

        sharedMemory.updateAgvPosOnMap(simulation);

        try{
            sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
