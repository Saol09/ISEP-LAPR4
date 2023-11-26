package eapli.base.app.backoffice.console.presentation.productsCategory;

import eapli.base.productsCategory.application.NewProductsCategoryController;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.Description;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;



public class NewProductsCategoryUI extends AbstractUI {

    private final NewProductsCategoryController controller = new NewProductsCategoryController();

    @Override
    protected boolean doShow() {

        String alphanumericCode;
        do{
            alphanumericCode = Console.readLine("Insert the alphanumeric code (between 1-10 characters):");

        }while (alphanumericCode.length() < 1 || alphanumericCode.length() > 10);
        AlphanumericCode code = new AlphanumericCode(alphanumericCode);


        String textstr;

        do{
            textstr = Console.readLine("Insert the Description (between 20-50 characters):");

        }while (textstr.length() < 20 || textstr.length() > 50);
        Description text = new Description(textstr);

        controller.newProductsCategory(code,text);

        return true;
    }

    @Override
    public String headline() {
        return "Create a new Products Category";
    }
}
