package eapli.base.app.backoffice.console.presentation.agvManager;
import eapli.base.agvManager.application.AGVManagerController;
import eapli.framework.presentation.console.AbstractUI;

public class AGVManagerUI extends AbstractUI {

    AGVManagerController ctr = new AGVManagerController();

    @Override
    protected boolean doShow() {
        ctr.mainLoop();
        return true;
    }

    @Override
    public String headline() {
        return "AGV Manager";
    }
}
