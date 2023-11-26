package eapli.base.shoppingCart.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.domain.Email;
import eapli.base.costumermanagement.repositories.CostumerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.application.ProductServices;
import eapli.base.product.domain.InternalCode;
import eapli.base.product.domain.Product;
import eapli.base.productOrderManagement.application.RegisterCostumerOrderController;
import eapli.base.productOrderManagement.domain.Item;
import eapli.base.shoppingCart.domain.ShoppingCart;
import eapli.base.shoppingCart.repository.ShoppingCartRepository;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * The type New shopping cart controller.
 */
public class NewShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepo = PersistenceContext.repositories().shoppingCartRepository();

    private final CostumerRepository costumerRepository = PersistenceContext.repositories().costumerRepository();

    private final CostumerRepository repoCostumer = PersistenceContext.repositories().costumerRepository();

    private ProductServices productServices = new ProductServices();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    /**
     * Create shopping cart shopping cart.
     *
     * @param costumer the costumer
     * @param items    the items
     * @return the shopping cart
     */
    public ShoppingCart createShoppingCart(Costumer costumer, Set<Item> items){

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CLIENT_USER);

        ShoppingCart shoppingCart = new ShoppingCart(costumer, items);

        return shoppingCartRepo.save(shoppingCart);
    }

    /**
     * Add products shopping cart.
     *
     * @param costumer the costumer
     * @param items    the items
     * @return the shopping cart
     */
    public ShoppingCart addProducts(Costumer costumer, Set<Item> items) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.CLIENT_USER);

        ShoppingCart shopping =  shoppingCartRepo.findShoppingCartByCostumer(costumer);

        Set<Item> lista = new HashSet<>(shopping.getProducts());

        for (Item itemLista : lista){ //já existentes
            for (Item item : items) { //os que vão ser adicionados
                if (Objects.equals(itemLista.getProductID(), item.getProductID())){
                    itemLista.setQuantity(itemLista.getQuantity()+item.getQuantity());
                    items.remove(item);
                }
            }
        }
        lista.addAll(items);

        shopping.setProducts(lista);

        return shoppingCartRepo.save(shopping);
    }

    /**
     * Check shopping cart boolean.
     *
     * @param userEmail the user email
     * @return the boolean
     */
    public boolean checkShoppingCart(String userEmail) {

        Email email = new Email(userEmail);
        Costumer costumer = costumerRepository.findCostumerByEmail(email);


        if (shoppingCartRepo.findShoppingCartByCostumer(costumer) == null)
            return false;


        return true;
    }

    /**
     * Check product id boolean.
     *
     * @param code the code
     * @return the boolean
     */
    public boolean checkProductId(InternalCode code) {
        Product productFound = productServices.findProductByCode(code);

        return productFound != null;
    }

    /**
     * Find costumer by costumer.
     *
     * @param email the email
     * @return the costumer
     */
    public Costumer findCostumerBy(String email) {

        Email email1 = new Email(email);

        return repoCostumer.findCostumerByEmail(email1);
    }

    /**
     * Show all.
     */
    public void showAll() {
        Iterable<ShoppingCart> products = shoppingCartRepo.findAll();
        for (ShoppingCart prod : products) {
            System.out.println(prod);
        }
    }


}
