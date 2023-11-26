package eapli.base.agvConfiguration.application;

import eapli.base.agvConfiguration.domain.*;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.IDagvDocks;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.base.plantmanagment.repository.WarehousePlantRepository;

import java.util.ArrayList;


/**
 * The type Agv configuration controller.
 */
public class AGVConfigurationController {

    private final AGVConfigurationRepository repoAGV = PersistenceContext.repositories().agvConfigurationRepository();
    private final WarehousePlantRepository repoWare = PersistenceContext.repositories().warehousePlantRepository();
    /**
     * The Services.
     */
    AGVServices services = new AGVServices();


    /**
     * New agv configuration agv.
     *
     * @param id               the id
     * @param maxWeight        the max weight
     * @param maxVolume        the max volume
     * @param model            the model
     * @param route            the route
     * @param shortDescription the short description
     * @param status           the status
     * @param autonomy         the autonomy
     * @param task             the task
     * @param agvDocks         the agv docks
     * @return the agv
     */
    public AGV newAGVConfiguration(Id id, MaxWeight maxWeight, MaxVolume maxVolume, Model model, Route route, ShortDescription shortDescription, AGV.Status status, Autonomy autonomy, Task task, AGVDocks agvDocks) {

        AGV agv = new AGV(id, maxWeight, maxVolume, model, route, shortDescription, status, autonomy, task, agvDocks);

        return repoAGV.save(agv);
    }

    /**
     * Change agv info agv.
     *
     * @param agv                      the agv
     * @param statusToChange           the status to change
     * @param autonomyToChange         the autonomy to change
     * @param routeToChange            the route to change
     * @param shortDescriptionToChange the short description to change
     * @param taskToChange             the task to change
     * @return the agv
     */
    public AGV changeAgvInfo(AGV agv, AGV.Status statusToChange, String autonomyToChange, int routeToChange, String shortDescriptionToChange, String taskToChange) {
        agv.changeStatusTo(statusToChange);
        agv.changeAutonomyTo(new Autonomy(autonomyToChange));
        agv.changeRouteTo(new Route(routeToChange));
        agv.changeShortDescriptionTo(new ShortDescription(shortDescriptionToChange));
        agv.changeTaskTo(new Task(taskToChange));

        return repoAGV.save(agv);
    }

    /**
     * Find all agv iterable.
     *
     * @return the iterable
     */
    public Iterable<AGV> findAllAGV() {
        return repoAGV.findAll();
    }

    /**
     * Check agv id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean checkAGVId(Id id) {
        AGV agvFound = services.findAGVID(id);

        return agvFound != null;
    }

    /**
     * Find agv agv.
     *
     * @param id the id
     * @return the agv
     */
    public AGV findAGV(Id id) {
        AGV agvF = services.findAGVID(id);

        return agvF;
    }

    /**
     * Find all agv dock array list.
     *
     * @return the array list
     */
    public ArrayList<String> findAllAGVDock() {
        Iterable<WarehousePlant> warehouse = repoWare.findAll();
        WarehousePlant warehousePlant = warehouse.iterator().next();
        ArrayList<String> list = new ArrayList<>();
        for (AGVDocks docks : warehousePlant.getAGVDocks()) {
            list.add("Dock ID: " + docks.getId());
        }
        return list;
    }

    /**
     * Check agv dock boolean.
     *
     * @param iDagvDocks the dagv docks
     * @return the boolean
     */
    public boolean checkAGVDock(IDagvDocks iDagvDocks) {
        AGVDocks agvDocksFound = services.findAGVDock(iDagvDocks);

        return agvDocksFound != null;
    }

    /**
     * Find agv dock agv docks.
     *
     * @param iDagvDocks the dagv docks
     * @return the agv docks
     */
    public AGVDocks findAGVDock(IDagvDocks iDagvDocks) {
        AGVDocks agvDocksF = services.findAGVDock(iDagvDocks);

        return agvDocksF;
    }

    /**
     * Change status.
     *
     * @param agvID      the agv id
     * @param statusType the status type
     */
    public void changeStatus(String agvID, AGV.Status statusType){
        AGV agv = repoAGV.findByAGVId(new Id(agvID));
        agv.changeStatusTo(statusType);
        repoAGV.save(agv);
    }


}
