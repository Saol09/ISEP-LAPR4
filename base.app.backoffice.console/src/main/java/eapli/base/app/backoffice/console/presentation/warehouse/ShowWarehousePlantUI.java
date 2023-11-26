package eapli.base.app.backoffice.console.presentation.warehouse;


import eapli.base.plantmanagment.application.WarehouseUploadController;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;

public class ShowWarehousePlantUI extends AbstractUI {


    private final WarehouseUploadController theController = new WarehouseUploadController();

    @Override
    protected boolean doShow() {



        System.out.println(theController.showWarehousePlant());

        return false;
    }

    @Override
    public String headline() {
        return "WAREHOUSE PLANT";
    }
}