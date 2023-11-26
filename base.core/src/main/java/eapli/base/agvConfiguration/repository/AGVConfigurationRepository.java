package eapli.base.agvConfiguration.repository;

import eapli.base.agvConfiguration.domain.*;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.framework.domain.repositories.DomainRepository;

public interface AGVConfigurationRepository extends DomainRepository<Id, AGV> {

    AGV findByAGVId(Id id);
    AGV findByAGVDock(AGVDocks agvDocks);
    Iterable<AGV> findAvailable(final double orderWeight, final double orderVolume);

    Iterable<AGV>  findOccupiedTask();
}
