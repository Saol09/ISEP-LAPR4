package eapli.base.persistence.impl.inmemory;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.IDagvDocks;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.base.plantmanagment.repository.WarehousePlantRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWarehousePlantRepository extends InMemoryDomainRepository<WarehousePlant,String> implements WarehousePlantRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public AGVDocks findByAGVDock(final IDagvDocks id) {
        return (AGVDocks) match(e -> e.getAGVDocks().equals(id));
    }
}
