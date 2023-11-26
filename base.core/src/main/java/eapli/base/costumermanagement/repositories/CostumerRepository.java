package eapli.base.costumermanagement.repositories;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.domain.Email;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

/**
 * The interface Costumer repository.
 */
public interface CostumerRepository extends DomainRepository<Long, Costumer> {

    /**
     * Find costumer by email costumer.
     *
     * @param email the email
     * @return the costumer
     */
    public Costumer findCostumerByEmail(Email email);
}
