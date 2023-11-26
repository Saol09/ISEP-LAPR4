package eapli.base.persistence.impl.jpa;

public class JpaAbstractRepository {

    @javax.persistence.PersistenceUnit
    private javax.persistence.EntityManagerFactory emFactory;
    private javax.persistence.EntityManager entityManager;


    protected javax.persistence.EntityManagerFactory entityManagerFactory() { return emFactory; }

    protected javax.persistence.EntityManager entityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory().createEntityManager();
        }
        return entityManager;
    }

    protected <R> javax.persistence.TypedQuery<R> createQuery(java.lang.String jpql, java.lang.Class<R> classz) { return entityManager().createQuery(jpql, classz);}

    protected <R> javax.persistence.Query createNativeQuery(java.lang.String sql, java.lang.Class<R> classz) { return entityManager().createNativeQuery(sql, classz); }


}
