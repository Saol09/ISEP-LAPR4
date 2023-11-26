package eapli.base.persistence.impl.inmemory;

import eapli.base.agvConfiguration.domain.AGV;
import eapli.base.agvConfiguration.domain.Id;
import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.domain.Email;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Optional;

public class InMemoryCostumerRepository extends InMemoryDomainRepository<Costumer, Long> implements CostumerRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Costumer findCostumerByEmail(Email email) {
        return (Costumer) match(e -> e.getEmail().equals(email));
    }



}
