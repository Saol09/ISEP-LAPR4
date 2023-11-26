package eapli.base.app.backoffice.console.presentation.product;


import eapli.base.product.application.SearchProductsController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;



public class SearchProductsUI extends AbstractUI {


    private final SearchProductsController controller = new SearchProductsController();


    @Override
    protected boolean doShow() {

        String answer1;

        do {
            System.out.println("1. Show all Products");
            System.out.println("2. Use Filters");
            System.out.println();
            answer1 = Console.readLine("Please choose an option");
            System.out.println();
        } while (!answer1.equals("1") && !answer1.equals("2"));


        switch (answer1) {

            case "1":
                controller.showAll();
                break;
            case "2":
                filters();
                break;
        }
        return false;
    }


    public void filters() {

        String category;
        String brand;
        String description;
        String answer2;
        String answer3 = "1";

        while (answer3.equals("1")){

            do {
                System.out.println();
                System.out.println("Filter:");
                System.out.println("1. Category");
                System.out.println("2. Brand");
                System.out.println("3. Description");
                System.out.println();
                answer2 = Console.readLine("Please choose an option");
            } while (!answer2.equals("1") && !answer2.equals("2") && !answer2.equals("3"));

            switch (answer2) {
                case "1":

                    controller.showCategorys();
                    System.out.println();
                    category = Console.readLine("Choose category's code: ");
                    description = Console.readLine("Choose category's description: ");
                    controller.filterByCategory(category, description);

                    break;
                case "2":

                    controller.showBrand();
                    System.out.println();
                    brand = Console.readLine("Filter by brand: ");
                    controller.filterByBrand(brand);

                    break;
                case "3":

                    controller.showDescription();
                    System.out.println();
                    description = Console.readLine("Filter by description: ");
                    controller.filterByDescription(description);

                    break;
            }

            do {
                System.out.println();
                answer3 = Console.readLine("Add another filter (1.yes / 2.no) : ");
            } while (!answer3.equals("1") && !answer3.equals("2"));

        }
    }



    @Override
    public String headline() {
        return "Search Products";
    }


}
