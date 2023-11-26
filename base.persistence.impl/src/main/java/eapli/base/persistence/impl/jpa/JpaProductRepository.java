package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.agvConfiguration.domain.ShortDescription;
import eapli.base.product.domain.Brand;
import eapli.base.product.domain.InternalCode;
import eapli.base.product.domain.Product;
import eapli.base.product.repository.ProductRepository;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.Description;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class JpaProductRepository extends JpaAutoTxRepository<Product, Long, Long> implements ProductRepository{

    public JpaProductRepository(String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),"eapli.base");
    }




    @Override
    public Iterable<Product> findByCategory(final String category, final String description) {
        AlphanumericCode alphanumericCode = new AlphanumericCode(category);
        Description description1 = new Description(description);
        ProductsCategory productsCategory = new ProductsCategory(alphanumericCode, description1);
        final TypedQuery<Product> q = createQuery("SELECT e FROM Product e WHERE  e.productsCategory = :category",
                Product.class);
        q.setParameter("category", productsCategory);
        return q.getResultList();
    }



    @Override
    public Iterable<Product> findByDescription(final String description) {
        ShortDescription shortDescription1 = new ShortDescription(description);
        final TypedQuery<Product> q = createQuery("SELECT e FROM Product e WHERE  e.shortDescription = :description",
                Product.class);
        q.setParameter("description", shortDescription1);
        return q.getResultList();
    }


    @Override
    public Iterable<Product> findByBrand(final String brand) {
        Brand brand1 = new Brand(brand);
        final TypedQuery<Product> q = createQuery("SELECT e FROM Product e WHERE  e.brand = :brand",
                Product.class);
        q.setParameter("brand", brand1);
        return q.getResultList();
    }







    public Product findByInternalCode(InternalCode internalCode) {
        try {
            Query query = super.entityManager().createQuery("SELECT p FROM Product p WHERE p.internalCode=:internalCode");
            query.setParameter("internalCode", internalCode);

            Product product = (Product) query.getSingleResult();
            return product;
        } catch (NoResultException e){
            return null;
        }
    }



    public Product findByID(Long id) {
        try {

            Query query = super.entityManager().createQuery("SELECT p FROM Product p WHERE p.id=:id");
            query.setParameter("id", id);

            Product product = (Product) query.getSingleResult();
            return product;
        } catch (NoResultException e){
            return null;
        }
    }



}
