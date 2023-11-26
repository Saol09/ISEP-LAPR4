package eapli.base.app.avgmanager;

import java.io.*;

public class AGVChangeStatusMessageParser {

    private final AGVChangeStatusController controller;

    public AGVChangeStatusMessageParser(final AGVChangeStatusController controller) {
        this.controller = controller;
    }

    private AGVChangeStatusController getController() {
        return this.controller;
    }

    public AGVManagerRequest parse(final byte code,
                                   final ObjectOutputStream sOutObj,
                                   final ObjectInputStream sInObj,
                                   final DataOutputStream sOut,
                                   final DataInputStream sIn,
                                   final byte[] clientMessage) throws IOException {

        AGVManagerRequest request = null;

        if (code == 3 || code == 4 || code == 5)
            request = new AGVChangeStatusRequest(code, controller, sOutObj, sIn, sOut, sInObj, clientMessage);

        if (request == null)
            throw new UnsupportedOperationException("Request " + code + " is not valid");

        return request;
    }
}
