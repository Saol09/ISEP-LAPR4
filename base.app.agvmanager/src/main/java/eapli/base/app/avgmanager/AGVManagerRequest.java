package eapli.base.app.avgmanager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AGVManagerRequest {

    protected final byte request;
    protected final AGVChangeStatusController controller;
    protected final ObjectOutputStream sOutputObj;
    protected final DataInputStream sIn;
    protected final DataOutputStream sOut;
    protected final ObjectInputStream sInObj;
    protected byte[] clientMessage;

    public AGVManagerRequest(byte request,
                             AGVChangeStatusController controller,
                             ObjectOutputStream sOutputObj,
                             DataInputStream sIn,
                             DataOutputStream sOut,
                             ObjectInputStream sInObj,
                             byte[] clientMessage) {
        this.request = request;
        this.controller = controller;
        this.sOutputObj = sOutputObj;
        this.sIn = sIn;
        this.sOut = sOut;
        this.sInObj = sInObj;
        this.clientMessage = clientMessage;
    }

    public abstract void execute();

    /*public abstract void execute() {
        Id agvId;
        try {
            agvId = new Id(agvID);
        } catch (final NumberFormatException e) {
            return "Invalid AGV ID";
        }
        controller.changeAgvStatus(agvId, status);
    }*/


}
