package shared;

import eapli.base.agvConfiguration.domain.Position;
import eapli.base.agvConfiguration.domain.Speed;
import eapli.base.common.util.Pair;
import eapli.base.plantmanagment.domain.WarehousePlant;

import java.util.LinkedList;
import java.util.List;

public class SharedMemory {

    private volatile String id;

    private volatile Pair<Integer,Integer> coordinates;

    private volatile Integer battery;

    private volatile String status;

    private volatile Pair<Integer,Integer>[] route;



    private List<Position>posList;

    private List<Speed> speedList;

    private List<LinkedList<Position>> routeList; //route planer list each agv will have one route

    private WarehousePlant plant;

    private List<String> idList;

    private int[][] agvPosOnMap;



    public SharedMemory(){}

    public SharedMemory(Pair<Integer, Integer> coordinates, Integer battery, String status) {
        this.coordinates = coordinates;
        this.battery = battery;
        this.status = status;
    }

    public String getId() {
        return this.id;
    }

    public Pair<Integer,Integer> getCoordinates(){
        return this.coordinates;
    }

    public String getCoordinatesAlternative(){
        return String.format("X: %d | Y: %d", this.coordinates.getKey(), this.coordinates.getValue());
    }

    public Integer getBattery() {
        return battery;
    }

    public String getStatus() {
        return this.status;
    }

    public Pair<Integer, Integer>[] getRoute() {
        return this.route;
    }

    public void updateCoordinates(Pair<Integer, Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public void updateBattery(Integer battery) {
        this.battery = battery;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public void updateRoute(Pair<Integer, Integer>[] route) {
        this.route = route;
    }


    public SharedMemory(List<Position> posList, List<Speed> speedList, List<LinkedList<Position>> routeList, WarehousePlant plant, List<String> idList, int[][] agvPosOnMap) {
        this.posList = posList;
        this.speedList = speedList;
        this.routeList = routeList;
        this.plant = plant;
        this.idList = idList;
        this.agvPosOnMap = agvPosOnMap;
    }

    public List<Position> getPosList() {
        return posList;
    }

    public List<Speed> getSpeedList() {
        return speedList;
    }

    public List<LinkedList<Position>> getRouteList() {
        return routeList;
    }

    public WarehousePlant getPlant() {
        return plant;
    }

    public List<String> getIdList() {
        return idList;
    }

    public int[][] getAgvPosOnMap() {
        return agvPosOnMap;
    }

    public void updatePosList(List<Position> posList) {
        this.posList = posList;
    }

    public void updateSpeedList(List<Speed> speedList) {
        this.speedList = speedList;
    }

    public void changeRouteList(List<LinkedList<Position>> routeList) {
        this.routeList = routeList;
    }

    public void updatePlant(WarehousePlant plant) {
        this.plant = plant;
    }

    public void updateAgvPosOnMap(int[][] agvPosOnMap) {
        this.agvPosOnMap = agvPosOnMap;
    }

    @Override
    public String toString() {
        return "SharedMemory{" +
                "posList=" + posList +
                ", speedList=" + speedList +
                ", routeList=" + routeList +
                ", plant=" + plant +
                ", idList=" + idList +
                '}';
    }
}
