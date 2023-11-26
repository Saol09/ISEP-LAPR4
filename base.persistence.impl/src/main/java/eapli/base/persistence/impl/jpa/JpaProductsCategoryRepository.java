package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.base.productsCategory.repository.ProductsCategoryRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

//
public class JpaProductsCategoryRepository extends JpaAutoTxRepository<ProductsCategory, AlphanumericCode, AlphanumericCode> implements ProductsCategoryRepository {

    public JpaProductsCategoryRepository(String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),"eapli.base");
    }





    @Override
    public Iterable<ProductsCategory> findByCode(final AlphanumericCode code) {
        final TypedQuery<ProductsCategory> q=createQuery("SELECT e FROM ProductsCategory e WHERE e.code = :code ",ProductsCategory.class);
        q.setParameter("code",code);
        return q.getResultList();
    }

}
