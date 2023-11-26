package eapli.base.app.backoffice.console.presentation.shoppingCart;

import eapli.base.app.backoffice.console.presentation.product.SearchProductsUI;
import eapli.base.costumermanagement.domain.Costumer;
import eapli.base.costumermanagement.domain.Email;
import eapli.base.product.domain.InternalCode;
import eapli.base.productOrderManagement.application.RegisterCostumerOrderController;
import eapli.base.productOrderManagement.domain.Item;
import eapli.base.shoppingCart.application.NewShoppingCartController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Create shopping cart ui.
 */
public class CreateShoppingCartUI extends AbstractUI {

    private final NewShoppingCartController shoppingCartController = new NewShoppingCartController();

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    protected boolean doShow() {



        String email = authz.session().get().authenticatedUser().email().toString();
        Costumer costumer = shoppingCartController.findCostumerBy(email);
        Set<Item> items = new HashSet<>();

        if (shoppingCartController.checkShoppingCart(email)) {

            System.out.println("You already have a shopping cart!");

            int choice = Console.readInteger("Do you wish to add more products to your shopping cart?\n1 -> Yes | 2 -> No");

            if (choice == 1) {

                while (true) {
                    int answer = Console.readInteger("Do you want to view the Products Catalog?\n 1 -> Yes | 2 -> No");
                    if (answer == 1) {
                        new SearchProductsUI().show();
                    }
                    final String productCode = Console.readLine("Product Unique Internal Code: ");

                    boolean productExist = this.shoppingCartController.checkProductId(new InternalCode(productCode));
                    if (!productExist)
                        System.out.println("The product code that you inserted is not present on our database.");
                    else {
                        Integer quantity = Console.readInteger("Please insert the quantity.");
                        if (items.contains(productCode))
                            System.out.println("Product already chosen.");
                        else {
                            items.add(new Item(productCode, quantity));
                        }

                        answer = Console.readInteger("Product added. Do you wish to add more? 1 -> Yes | 2 -> No");
                        if (answer == 2) {

                            break;
                        }
                    }
                }
                shoppingCartController.addProducts(costumer, items);
                shoppingCartController.showAll();
            }

        } else {

            int choice = Console.readInteger("Do you want to add products to your shopping cart?\n1 -> Yes | 2 -> No");

            if (choice == 1) {

                while (true) {
                    int answer = Console.readInteger("Do you want to view the Products Catalog?\n 1 -> Yes | 2 -> No");
                    if (answer == 1) {
                        new SearchProductsUI().show();
                    }
                    final String productCode = Console.readLine("Product Unique Internal Code: ");

                    boolean productExist = this.shoppingCartController.checkProductId(new InternalCode(productCode));
                    if (!productExist)
                        System.out.println("The product code that you inserted is not present on our database.");
                    else {
                        Integer quantity = Console.readInteger("Please insert the quantity.");
                        if (items.contains(productCode))
                            System.out.println("Product already chosen.");
                        else {
                            items.add(new Item(productCode, quantity));
                        }

                        answer = Console.readInteger("Product added. Do you wish to add more? 1 -> Yes | 2 -> No");
                        if (answer == 2) {

                            break;
                        }
                    }
                }
            }
            shoppingCartController.createShoppingCart(costumer, items);
            shoppingCartController.showAll();
        }

        return true;
    }


    @Override
    public String headline() {
        return "Shopping > ";
    }
}
