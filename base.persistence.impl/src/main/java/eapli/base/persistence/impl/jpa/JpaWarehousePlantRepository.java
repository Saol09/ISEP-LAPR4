package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.IDagvDocks;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.base.plantmanagment.repository.WarehousePlantRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.hibernate.CacheMode;
import org.hibernate.jpa.QueryHints;

import javax.persistence.CacheRetrieveMode;
import javax.persistence.CacheStoreMode;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class JpaWarehousePlantRepository extends JpaAutoTxRepository<WarehousePlant,String,String> implements WarehousePlantRepository {

    public JpaWarehousePlantRepository(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }

    public JpaWarehousePlantRepository(String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),"eapli.base");
    }

    @Override
    public AGVDocks findByAGVDock(IDagvDocks id) {
        try {
            Query query = super.entityManager().createQuery("SELECT p FROM AGVDocks p WHERE p.id=:id");
            query.setParameter("id", id);

            AGVDocks agvDocks = (AGVDocks) query.getSingleResult();
            return agvDocks;
        } catch (NoResultException e) {
            return null;
        }
    }
}
