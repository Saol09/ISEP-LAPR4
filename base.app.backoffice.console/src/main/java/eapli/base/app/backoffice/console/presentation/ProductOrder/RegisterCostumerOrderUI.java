package eapli.base.app.backoffice.console.presentation.ProductOrder;

import eapli.base.app.backoffice.console.presentation.Costumer.RegisterCostumerUI;
import eapli.base.app.backoffice.console.presentation.product.NewProductUI;
import eapli.base.app.backoffice.console.presentation.product.SearchProductsUI;
import eapli.base.costumermanagement.domain.Address;
import eapli.base.product.domain.InternalCode;
import eapli.base.productOrderManagement.application.RegisterCostumerOrderController;
import eapli.base.productOrderManagement.domain.Item;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.domain.Shipment;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class RegisterCostumerOrderUI extends AbstractUI {

    private final RegisterCostumerOrderController controller = new RegisterCostumerOrderController();

    @Override
    protected boolean doShow() {

        Set<Item> items = new HashSet<>();
        int extraProducts = 0;

        while (true) {
            int answer = Console.readInteger("Do you want to view the Products Catalog?\n 1 -> Yes | 2 -> No\n");
            if (answer == 1)
                new SearchProductsUI().show();

            final String productCode = Console.readLine("Product Unique Internal Code: ");

            boolean productExist = this.controller.checkProductId(new InternalCode(productCode));
            if (!productExist)
                System.out.println("The product code that you inserted is not present on our database.");
            else {
                Integer quantity = Console.readInteger("Please insert the quantity.");
                if (items.contains(productCode))
                    System.out.println("Product already chosen.");
                else
                    items.add(new Item(productCode, quantity));

                answer = Console.readInteger("Product added. Do you wish to add more? 1 -> Yes | 2 -> No");
                if (answer == 2)
                    break;
            }
        }

        final Long costumerID = Console.readLong("Insert the client ID");
        boolean costumerFromDb = this.controller.checkCostumerId(costumerID);

        if(!costumerFromDb)
            new RegisterCostumerUI().show();

        List<Address> addressList = new ArrayList<>();
        for( int i = 0; i<2; i++){
            if (i == 0){
                System.out.println("--------------------------------------------------------------\n");
                System.out.println("                      Delivering Address\n");
                System.out.println("--------------------------------------------------------------\n");
            } else {
                System.out.println("--------------------------------------------------------------\n");
                System.out.println("                      Billing Address\n");
                System.out.println("--------------------------------------------------------------\n");
            }
            String streetName = Console.readLine("Insert your street name.");
            String postalCode = Console.readLine("Insert your postal code.");
            String city = Console.readLine("Insert your city.");
            String country = Console.readLine("Insert your country.");
            int doorNumber = Console.readInteger("Insert your door number");
            addressList.add(new Address(streetName, doorNumber, postalCode, city, country));
        }
        int i = 1;
        System.out.println("\n--------------------------------------------------------------\n");
        System.out.println("                      Shipment Method\n");
        System.out.println("--------------------------------------------------------------\n");
        for (Shipment s : Shipment.values()) {
            System.out.printf(i + " " + s.name() + " Price: " + s.cost() +"\n");
            i++;
        }

        int choice = Console.readInteger("Select: ");
        if (choice >= i ||  choice < 0) {
            throw new UnsupportedOperationException("Invalid Option");
        }

        Shipment shipment = Shipment.values()[choice];

        i = 1;
        System.out.println("\n--------------------------------------------------------------\n");
        System.out.println("                      Payment Method\n");
        System.out.println("--------------------------------------------------------------\n");
        for (ProductOrder.PaymentMethod s : ProductOrder.PaymentMethod.values()) {
            System.out.printf(i + " " + s.name()+"\n");
            i++;
        }
        choice = 15;
        choice = Console.readInteger("Select: ");
        if (choice >= i ||  choice < 0) {
            throw new UnsupportedOperationException("Invalid Option");
        }

        ProductOrder.PaymentMethod paymentMethod = ProductOrder.PaymentMethod.values()[choice];

        i = 1;

        System.out.println("\n--------------------------------------------------------------\n");
        System.out.println("                      Communication Method\n");
        System.out.println("--------------------------------------------------------------\n");
        for (ProductOrder.CommunicationMethod s : ProductOrder.CommunicationMethod.values()) {
            System.out.printf(i + " " + s.name()+"\n");
            i++;
        }
        choice = 15;
        choice = Console.readInteger("Select: ");
        if (choice >= i ||  choice < 0) {
            throw new UnsupportedOperationException("Invalid Option");
        }

        ProductOrder.CommunicationMethod communicationMethod = ProductOrder.CommunicationMethod.values()[choice];
        Calendar communicationDate = Console.readCalendar("When did you communicates with the costumer? Please insert in the format yyyy-MM-dd: ","yyyy-MM-dd");

        int commentC = Console.readInteger("Do you want to add any additional commentary? 1 -> Yes | 2 -> No");
        if(commentC == 1){
            String comment = Console.readLine("Insert your comment: ");
            controller.registerOrder(items, addressList.get(0), addressList.get(1), shipment, communicationMethod, communicationDate, comment, paymentMethod);
        }else
            controller.registerOrder(items, addressList.get(0), addressList.get(1), shipment, communicationMethod, communicationDate, paymentMethod);

        return false;
    }

    @Override
    public String headline() {
        return "Register Costumer Order";
    }
}
