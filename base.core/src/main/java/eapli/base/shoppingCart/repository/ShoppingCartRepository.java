package eapli.base.shoppingCart.repository;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.shoppingCart.domain.ShoppingCart;
import eapli.framework.domain.repositories.DomainRepository;

/**
 * The interface Shopping cart repository.
 */
public interface ShoppingCartRepository extends DomainRepository<Long, ShoppingCart> {

    /**
     * Find shopping cart by costumer shopping cart.
     *
     * @param costumer the costumer
     * @return the shopping cart
     */
    public ShoppingCart findShoppingCartByCostumer(Costumer costumer);

    //public ShoppingCart updateItemByProductID(String productID, int nrItens1, int nrItens2);
}
