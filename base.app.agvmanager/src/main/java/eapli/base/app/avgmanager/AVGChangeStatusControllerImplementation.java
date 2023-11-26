package eapli.base.app.avgmanager;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Id;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AVGChangeStatusControllerImplementation implements AGVChangeStatusController {

    private final AGVConfigurationRepository agvRepo = PersistenceContext.repositories().agvConfigurationRepository();

    @Override
    public void changeStatusFree(Id agvID) {
        AGV agv = agvRepo.findByAGVId(agvID);
        agv.changeStatusTo(AGV.Status.FREE);
        agvRepo.save(agv);
    }

    @Override
    public void changeStatusCharging(Id agvID) {
        AGV agv = agvRepo.findByAGVId(agvID);
        agv.changeStatusTo(AGV.Status.OCCUPIED_CHARGING);
        agvRepo.save(agv);
    }

    @Override
    public void changeStatusTask(Id agvID) {
        AGV agv = agvRepo.findByAGVId(agvID);
        agv.changeStatusTo(AGV.Status.OCCUPIED_DOING_TASK);
        agvRepo.save(agv);
    }

}
