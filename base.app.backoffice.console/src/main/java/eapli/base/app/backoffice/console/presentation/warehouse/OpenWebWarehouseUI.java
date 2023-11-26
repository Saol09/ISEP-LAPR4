package eapli.base.app.backoffice.console.presentation.warehouse;

//import eapli.base.warehouseServer.ServerCommunicator;
//import eapli.base.warehouseServer.application.OpenWarehouseController;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class OpenWebWarehouseUI extends AbstractUI {


    @Override
    protected boolean doShow() {


        System.out.println("Open Browser "+"http://localhost:2020/");

        return false;
    }

    @Override
    public String headline() {
        return "WEB";
    }
}
