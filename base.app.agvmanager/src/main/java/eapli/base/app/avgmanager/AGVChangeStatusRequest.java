package eapli.base.app.avgmanager;

import eapli.base.agvConfiguration.domain.Id;
import eapli.base.utils.TCPMessageUtils;

import java.io.*;

public class AGVChangeStatusRequest extends AGVManagerRequest {

    public AGVChangeStatusRequest(byte request, AGVChangeStatusController controller, ObjectOutputStream sOutputObj, DataInputStream sIn, DataOutputStream sOut, ObjectInputStream sInObj, byte[] clientMessage) {
        super(request, controller, sOutputObj, sIn, sOut, sInObj, clientMessage);
    }

    @Override
    public void execute() {
        try {
            Id id = new Id(TCPMessageUtils.getDataFromMessage(clientMessage, sIn));
            if (request == 3)
                this.controller.changeStatusFree(id);
            if (request == 4)
                this.controller.changeStatusCharging(id);
            if (request == 5)
                this.controller.changeStatusTask(id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
