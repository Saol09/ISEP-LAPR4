package eapli.base.plantmanagment.repository;


import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Id;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.IDagvDocks;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.framework.domain.repositories.DomainRepository;

/**
 * The interface Warehouse plant repository.
 */
public interface WarehousePlantRepository extends DomainRepository<String,WarehousePlant> {
    /**
     * Find by agv dock agv docks.
     *
     * @param id the id
     * @return the agv docks
     */
    AGVDocks findByAGVDock (IDagvDocks id);



}
