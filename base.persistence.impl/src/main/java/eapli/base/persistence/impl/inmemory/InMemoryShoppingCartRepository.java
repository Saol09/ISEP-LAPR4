package eapli.base.persistence.impl.inmemory;

import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.shoppingCart.domain.ShoppingCart;
import eapli.base.shoppingCart.repository.ShoppingCartRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryShoppingCartRepository extends InMemoryDomainRepository<ShoppingCart,Long> implements ShoppingCartRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public ShoppingCart findShoppingCartByCostumer(Costumer costumer) {
        return (ShoppingCart) match(e -> e.getCostumer().equals(costumer));
    }

    /*@Override
    public ShoppingCart updateItemByProductID(String productID, int nrItens1, int nrItens2) {
        return (null) *//*match(e ->e.getProducts().equals())*//*;
    }*/


    /*@Override
    public Optional<ClientUser> findByUsername(final Username name) {
        return matchOne(e -> e.user().username().equals(name));
    }*/



}
