package eapli.base.app.avgmanager;

public abstract class AVGManagerProtocolRequest {

    protected final String request;

    protected final AGVChangeStatusController controller;

    protected AVGManagerProtocolRequest(final AVGChangeStatusControllerImplementation controller, final String inputRequest) {
        this.request = inputRequest;
        this.controller = controller;
    }

    public abstract String execute();

    public boolean isGoodbye() {
        return false;
    }

}
