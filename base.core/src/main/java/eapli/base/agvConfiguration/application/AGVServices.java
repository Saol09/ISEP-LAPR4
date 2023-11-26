package eapli.base.agvConfiguration.application;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Id;
import eapli.base.agvConfiguration.domain.MaxWeight;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.IDagvDocks;
import eapli.base.plantmanagment.repository.WarehousePlantRepository;
import eapli.framework.application.ApplicationService;

/**
 * The type Agv services.
 */
@ApplicationService
public class AGVServices {
    private final AGVConfigurationRepository repository = PersistenceContext.repositories().agvConfigurationRepository();
    private final WarehousePlantRepository repositoryWare = PersistenceContext.repositories().warehousePlantRepository();

    /**
     * Find agvid agv.
     *
     * @param id the id
     * @return the agv
     */
    public AGV findAGVID(Id id) {
        return repository.findByAGVId(id);
    }

    /**
     * Find agv dock agv docks.
     *
     * @param id the id
     * @return the agv docks
     */
    public AGVDocks findAGVDock(IDagvDocks id) {
        return repositoryWare.findByAGVDock(id);
    }

//    public AGV findWeightAGV(MaxWeight maxWeight){
//        return repository.findByWeightAGV(maxWeight);
//    }
}

