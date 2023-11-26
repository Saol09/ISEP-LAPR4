package eapli.base.app.backoffice.console.presentation.warehouse;


import eapli.base.plantmanagment.application.WarehouseUploadController;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class WarehouseUploadUI extends AbstractUI {

    private static final boolean VERSION = false;

    private final WarehouseUploadController theController = new WarehouseUploadController();

    @Override
    protected boolean doShow() {

        final String file_name = Console.readLine("File Name");


        theController.createPlant(file_name,VERSION);


        System.out.println(theController.showWarehousePlant());

        return false;
    }

    @Override
    public String headline() {
        return "Enter JSON file";
    }
}
