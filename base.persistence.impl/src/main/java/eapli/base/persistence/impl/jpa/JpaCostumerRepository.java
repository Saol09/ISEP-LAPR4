package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.domain.Email;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaCostumerRepository extends JpaAutoTxRepository<Costumer, Long, Long> implements CostumerRepository {

    public JpaCostumerRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCostumerRepository(String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),"id");

    }

    /*@Override
    public Optional<Costumer> findByCostumerByEmail(Email email){

        final Map<String, Object> params = new HashMap<>();
        params.put("email",email);
        return matchOne("e.email=:email",params);
    }*/

    public Costumer findCostumerByEmail(Email email) {
        try {
            Query query = super.entityManager().createQuery("SELECT p FROM Costumer p WHERE p.email=:email");
            query.setParameter("email", email);

            Costumer costumer = (Costumer) query.getSingleResult();
            return costumer;
        } catch (NoResultException e) {
            return null;
        }
    }
}
