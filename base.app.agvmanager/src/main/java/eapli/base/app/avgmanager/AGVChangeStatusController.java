package eapli.base.app.avgmanager;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Id;

public interface AGVChangeStatusController {
    void changeStatusFree(Id agvID);

    void changeStatusCharging(Id agvID);

    void changeStatusTask(Id agvID);
}
