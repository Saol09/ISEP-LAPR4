package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.agvConfiguration.application.AGVConfigurationController;
import eapli.base.agvConfiguration.domain.*;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.IDagvDocks;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;


public class AGVConfigurationUI extends AbstractUI {

    AGVConfigurationController ctr = new AGVConfigurationController();

    @Override
    protected boolean doShow() {
        String idInput;
        String autonomyInput;
        double maxVolumeInput;
        double maxWeightInput;
        String modelInput;
        String shortDescriptionInput;
        int routeInput;
        AGV.Status statusInput;
        String taskInput;
        String agvDockInput;


        String idToChange;
        String autonomyToChange;
        int routeToChange;
        AGV.Status statusToChange;
        String taskToChange;
        String shortDescriptionToChange;
        String input;

        List<AGV> listAGVChange = ((List) ctr.findAllAGV());
        List<String> listAGVDocks = ctr.findAllAGVDock();


        boolean valid = false;
        do {
            input = Console.readLine("1) Configure AGV\n2) Change AGV Information\n0) Exit");

            switch (input) {
                case "1":
                    System.out.println(listAGVDocks);
                    agvDockInput = Console.readLine("Choose an AGV Dock ID: ");

                    boolean isAGVDockUsed = false;
                    for (AGV agv : listAGVChange) {
                        if (agv.getAgvDocks().getId().getId().equals(agvDockInput)) {
                            isAGVDockUsed = true;
                            System.out.println("This AGV Dock ID already has an AGV, please insert a different ID.");
                            break;
                        }
                    }
                    if (isAGVDockUsed) {
                        continue;
                    }

                    AGVDocks agvD = ctr.findAGVDock(new IDagvDocks(agvDockInput));
                    boolean agvDExists = ctr.checkAGVDock(new IDagvDocks(agvDockInput));
                    if (!agvDExists)
                        System.out.println("The AGV id that you inserted is not present on our database.");
                    else {
                        do {
                            idInput = Console.readLine("Enter AGV ID (max 8 alphanumeric): ");
                        } while ((idInput.length() <= 0 || idInput.length() > 8));
                        Id id = new Id(idInput);
                        do {
                            maxVolumeInput = Console.readDouble("Enter AGV Max Volume: ");
                        } while ((maxVolumeInput <= 0));
                        MaxVolume maxVolume = new MaxVolume(maxVolumeInput);

                        do {
                            maxWeightInput = Console.readDouble("Enter AGV Max Weight: ");
                        } while ((maxWeightInput <= 0));
                        MaxWeight maxWeight = new MaxWeight(maxWeightInput);

                        do {
                            modelInput = Console.readLine("Enter AGV Model (max 50 characters): ");
                        } while ((modelInput.length() <= 0 || modelInput.length() >= 50));
                        Model model = new Model(modelInput);

                        routeInput = Console.readInteger("Enter AGV Route: ");

                        do {
                            shortDescriptionInput = Console.readLine("Enter AGV Short Description (max 30 characters): ");
                        } while ((shortDescriptionInput.length() <= 0 || shortDescriptionInput.length() >= 30));
                        ShortDescription shortDescription = new ShortDescription(shortDescriptionInput);

                        int statusChosen;
                        statusChosen = Console.readInteger("Enter AGV Status:\n\t1)free\n\t2)occupied charging\n\t3)charging doing a task");
                        switch (statusChosen) {
                            case 1:
                                statusInput = AGV.Status.FREE;

                                break;
                            case 2:
                                statusInput = AGV.Status.OCCUPIED_CHARGING;
                                break;
                            case 3:
                                statusInput = AGV.Status.OCCUPIED_DOING_TASK;
                                break;
                            default:
                                continue;
                        }
                        autonomyInput = Console.readLine("Enter AGV Autonomy: ");
                        taskInput = Console.readLine("Enter AGV Task: ");


                        Route route = new Route(routeInput);
//
                        Autonomy autonomy = new Autonomy(autonomyInput);
                        Task task = new Task(taskInput);

                        ctr.newAGVConfiguration(id, maxWeight, maxVolume, model, route, shortDescription, statusInput, autonomy, task, agvD);
                        valid = true;
                    }
                    break;

                case "2":
                    System.out.println(listAGVChange);
                    idToChange = Console.readLine("\nPlease write the AGV ID to change his info: ");

                    AGV agv = ctr.findAGV(new Id(idToChange));
                    boolean agvExists = ctr.checkAGVId(new Id(idToChange));
                    if (!agvExists)
                        System.out.println("The AGV id that you inserted is not present on our database.");
                    else {
                        int statusChosenToChange;
                        statusChosenToChange = Console.readInteger("Enter new AGV Status:\n\t1)free\n\t2)occupied charging\n\t3)charging doing a task");
                        switch (statusChosenToChange) {
                            case 1:
                                statusToChange = AGV.Status.FREE;
                                break;
                            case 2:
                                statusToChange = AGV.Status.OCCUPIED_CHARGING;
                                break;
                            case 3:
                                statusToChange = AGV.Status.OCCUPIED_DOING_TASK;
                                break;
                            default:
                                continue;
                        }
                        autonomyToChange = Console.readLine("\nPlease insert new Autonomy: ");
                        routeToChange = Console.readInteger("\nPlease insert new Route: ");
                        shortDescriptionToChange = Console.readLine("\nPlease insert new Short Description: ");
                        taskToChange = Console.readLine("\nPlease insert new Task: ");
                        ctr.changeAgvInfo(agv, statusToChange, autonomyToChange, routeToChange, shortDescriptionToChange, taskToChange);
                        valid = true;
                    }

                    break;
                case "0":
                    System.out.println("Exiting");
                    System.exit(0);
                default:
                    System.out.println("Unknown error has occurred.");
            }

        }
        while (!valid);
        return true;
    }

    @Override
    public String headline() {
        return "AGV Configuration";
    }
}
