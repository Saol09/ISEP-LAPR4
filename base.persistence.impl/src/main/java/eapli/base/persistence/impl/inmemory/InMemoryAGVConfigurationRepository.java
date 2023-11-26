package eapli.base.persistence.impl.inmemory;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Id;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class InMemoryAGVConfigurationRepository extends InMemoryDomainRepository<AGV, Id> implements AGVConfigurationRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public AGV findByAGVId(final Id id) {
        return (AGV) match(e -> e.getId().getId().equals(id));
    }


    public AGV findByAGVDock(AGVDocks agvDocks) {
        return null;
    }


    public Iterable<AGV> findAvailable(final double orderWeight, final double orderVolume) {
        return null;
    }

    public Iterable<AGV> findOccupiedTask() {
        return null;
    }
}