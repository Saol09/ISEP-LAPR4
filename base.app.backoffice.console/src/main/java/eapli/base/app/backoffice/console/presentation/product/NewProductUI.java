package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.agvConfiguration.domain.ShortDescription;
import eapli.base.product.actions.CatPrinter;
import eapli.base.product.application.NewProductController;
import eapli.base.product.domain.*;
import eapli.base.productsCategory.application.NewProductsCategoryController;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.framework.general.domain.model.Money;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class NewProductUI extends AbstractUI {

    private final NewProductController controller = new NewProductController();
    private final NewProductsCategoryController catController = new NewProductsCategoryController();

    @Override
    protected boolean doShow() {

        InternalCode internalCodeSTR = null;
        ShortDescription shortDescriptionSTR = null;
        double weight = 0;
        double volume = 0;
        ProductsCategory cats = null;
        Brand brandSTR = null;
        TechnicalDescription technicalDescriptionSTR = null;
        Money priceWithSTR = null;
        ExtendedDescription extendedDescriptionSTR = null;
        ProductionCode productionCodeSTR = null;
        Barcode barcodeSTR = null;
        Set<String> photoPaths = null;
        ProductLocation locationSTR = null;
        Reference referenceSTR = null;
        Money priceWithoutSTR = null;
        boolean status = false;
        boolean flag = true;
        String choiceFlag;



        while (flag) {
            String internalCode;
            do {
                internalCode = Console.readLine("Insert a alphanumeric code to be the internal code (between 1-23 characters):");

            } while (internalCode.length() < 1 || internalCode.length() > 23);
            internalCodeSTR = new InternalCode(internalCode);

            String shortDescription;
            do {
                shortDescription = Console.readLine("Insert a short Description (between 1-30 characters):");

            } while (shortDescription.length() < 1 || shortDescription.length() > 23);
            shortDescriptionSTR = new ShortDescription(shortDescription);

            String extendedDescription;
            do {
                extendedDescription = Console.readLine("Insert a extended description (between 20-100 characters):");

            } while (extendedDescription.length() < 20 || extendedDescription.length() > 100);
            extendedDescriptionSTR = new ExtendedDescription(extendedDescription);

            String technicalDescription;

            technicalDescription = Console.readLine("Insert a technical description:");


            technicalDescriptionSTR = new TechnicalDescription(technicalDescription);


            String brand;
            do {
                brand = Console.readLine("Insert the brand (between 1-50 characters):");

            } while (brand.length() < 1 || brand.length() > 50);
            brandSTR = new Brand(brand);

            String reference;
            do {
                reference = Console.readLine("Insert reference (between 1-23 characters):");

            } while (reference.length() < 1 || reference.length() > 23);
            referenceSTR = new Reference(reference);

            //Photo


            Integer choose;
            Long ean, upc;


            barcodeSTR = null;

            choose = Console.readInteger("Do you want the Barcode to be with what valid coding " +
                    "standard:\n1.UPC\n2.EAN-13");
            switch (choose) {
                case 1:
                    do {
                        upc = Console.readLong("Insert reference of barcode(12 digits):");

                    } while (upc <= 99999999999L | upc >= 999999999999L);
                    barcodeSTR = new Barcode(upc, Product.TYPE.UPC);
                    break;
                case 2:
                    do {
                        ean = Console.readLong("Insert reference of barcode(13 digits):");

                    } while (ean.toString().length() != 13);
                    barcodeSTR = new Barcode(ean, Product.TYPE.EAN13);
                    break;
            }

            int chooseProductionCode;
            chooseProductionCode = Console.readInteger("Do you want to insert a production code?(1/2)\n1.Yes\n2.No");
            String productionCode = null;
            if (chooseProductionCode == 1) {
                do {
                    productionCode = Console.readLine("Insert a production code (maximum 23 characters ):");

                } while (productionCode.length() < 1 || productionCode.length() > 23);
                productionCodeSTR = new ProductionCode(productionCode);
            }


            Double amount = 0.0;
            amount = Console.readDouble("Insert the price without taxes of the product:");
            priceWithoutSTR = Money.euros(amount);

            Double amountWith = 0.0;
            amountWith = Console.readDouble("Insert the price with taxes of the product:");
            priceWithSTR = Money.euros(amountWith);

            photoPaths = new HashSet<>();
            String option;

            do {
                String photoPath = Console.readLine("Photo Path:");
                File file = new File(photoPath);
                while (!file.exists()) {
                    photoPath = Console.readLine("Invalid Photo Path! Insert a new one:");
                    file = new File(photoPath);
                }
                if (Files.exists(Paths.get(photoPath)) && !photoPaths.contains(photoPath)) {
                    photoPaths.add(photoPath);


                } else if (!Files.exists(Paths.get(photoPath))) {
                    System.out.println("Wrong Path Inserted");
                } else {
                    System.out.println("This photo was already added");
                }
                option = Console.readLine("Do you want to add another photo? (yes|no)");
            } while (option.equalsIgnoreCase("yes"));


            weight = Console.readDouble("Insert the weight of the product:");

            volume = Console.readDouble("Insert the volume of the product:");


            List<ProductsCategory> listCat = catController.showAllCategories();

            final SelectWidget<ProductsCategory> selectorCat = new SelectWidget<>("Select a Category", listCat, new CatPrinter());
            selectorCat.show();
            cats = selectorCat.selectedElement();

            int locationA, locationB, locationC;
            locationA = Console.readInteger("Insert the location attributes:\n\nInsert ailse:");
            locationB = Console.readInteger("Insert row:");
            locationC = Console.readInteger("Insert shelf:");
            locationSTR = new ProductLocation(locationA, locationB, locationC);


            String choiceStatus;
            choiceStatus = Console.readLine("Is this product active or not(Yes/No)");
            if (choiceStatus.equalsIgnoreCase("yes")) {
                status = true;
            }


            choiceFlag = Console.readLine("Do Confirm this data? \n 1 -> Yes \n 2 -> No");
            if (choiceFlag.equalsIgnoreCase("1"))
                flag = false;
        }

        controller.newProduct(internalCodeSTR,shortDescriptionSTR,extendedDescriptionSTR,technicalDescriptionSTR,brandSTR,
                referenceSTR,photoPaths,barcodeSTR,productionCodeSTR,priceWithoutSTR,priceWithSTR,weight,volume,cats,
                locationSTR,status);

        return true;
    }


    @Override
    public String headline() {
        return "Create a new Product";
    }
}

