package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.agvConfiguration.domain.*;
import eapli.base.agvConfiguration.repository.AGVConfigurationRepository;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.WarehousePlant;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JpaAGVConfigurationRepository extends JpaAutoTxRepository<AGV, Id, Id> implements AGVConfigurationRepository {

    public JpaAGVConfigurationRepository(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }

    public JpaAGVConfigurationRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");

    }

    @Override
    public Iterable<AGV> findAll(){
        try {
            Query query = super.entityManager().createQuery("select e From AGV e");
//            query.setHint();
//            query.setHint();
//            query.setHint();
//
            Iterable<AGV> agvs = (Iterable<AGV>) query.getResultList();
            for (AGV agv:agvs){
                entityManager().detach(agv);
            }
            return agvs;

        }catch (NoResultException e){
            return null;
        }
    }

    public AGV findByAGVId(Id id) {
        try {
            Query query = super.entityManager().createQuery("SELECT p FROM AGV p WHERE p.id=:id");
            query.setParameter("id", id);

            AGV agv = (AGV) query.getSingleResult();
            return agv;
        } catch (NoResultException e) {
            return null;
        }
    }

    public AGV findByAGVDock(AGVDocks agvDocks) {
        try {


            final TypedQuery<AGV> agvTypedQuery = createQuery("SELECT e FROM AGV e WHERE e.agvDocks_id=:agvDocks_id", AGV.class);
            agvTypedQuery.setParameter("agvDocks_id", agvDocks.getId());

            return agvTypedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public Iterable<AGV> findAvailable(final double orderWeight, final double orderVolume) {
        try {
            AGV.Status status = AGV.Status.FREE;
            MaxWeight maxWeight = new MaxWeight(orderWeight);
            MaxVolume maxVolume = new MaxVolume(orderVolume);
            final TypedQuery<AGV> agvTypedQuery = createQuery("SELECT e FROM AGV e WHERE e.status=:status AND :orderWeight <=e.maxWeight AND :orderVolume <= e.maxVolume", AGV.class);
            agvTypedQuery.setParameter("status", status);
            agvTypedQuery.setParameter("orderWeight", maxWeight);
            agvTypedQuery.setParameter("orderVolume", maxVolume);
            return agvTypedQuery.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Iterable<AGV> findOccupiedTask() {
        try {
            AGV.Status status = AGV.Status.OCCUPIED_DOING_TASK;
            final TypedQuery<AGV> agvTypedQuery = createQuery("SELECT e FROM AGV e WHERE e.status=:status", AGV.class);
            agvTypedQuery.setParameter("status", status);

            return agvTypedQuery.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }




}
