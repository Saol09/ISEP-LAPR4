package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.productOrderManagement.domain.Item;
import eapli.base.shoppingCart.domain.ShoppingCart;
import eapli.base.shoppingCart.repository.ShoppingCartRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public class JpaShoppingCartRepository extends JpaAutoTxRepository<ShoppingCart, Long, Long> implements ShoppingCartRepository {

    public JpaShoppingCartRepository(String puname){
        super(puname, Application.settings().getExtendedPersistenceProperties(),"eapli.base");
    }

    public ShoppingCart findShoppingCartByCostumer(Costumer costumer) {
        try {
            Query query = super.entityManager().createQuery("SELECT p FROM ShoppingCart p WHERE p.costumer=:costumer");
            query.setParameter("costumer", costumer);

            ShoppingCart shoppingCart = (ShoppingCart) query.getSingleResult();
            return shoppingCart;
        } catch (NoResultException e) {
            return null;
        }
    }

    /*public ShoppingCart updateItemByProductID(String productID, int nrItens1, int nrItens2) {
        try {
            Query query = super.entityManager().createQuery("UPDATE SHOPPINGCART_PRODUCTS SET QUANTITY = QUANTITY + 1 WHERE PRODUCTID = '35b6a';");
            //(UPDATE SHOPPINGCART_PRODUCTS SET QUANTITY = QUANTITY + 1 WHERE PRODUCTID = '35b6a');
            query.setParameter("productID", productID);
            query.setParameter("nrItens1",nrItens1);
            query.setParameter("nrItens2",nrItens2);


            ShoppingCart item = (ShoppingCart) query.getSingleResult();
            return item;
        } catch (NoResultException e) {
            return null;
        }
    }*/


}
