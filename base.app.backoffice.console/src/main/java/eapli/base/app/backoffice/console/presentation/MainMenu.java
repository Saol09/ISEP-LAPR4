/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.Costumer.RegisterCostumerUI;
import eapli.base.app.backoffice.console.presentation.ProductOrder.ChangeOrderStatusToBeingDeliveredUI;
import eapli.base.app.backoffice.console.presentation.ProductOrder.ChangeOrderStatusUI;
import eapli.base.app.backoffice.console.presentation.ProductOrder.CheckStatusOpenOrdersUI;
import eapli.base.app.backoffice.console.presentation.ProductOrder.RegisterCostumerOrderUI;
import eapli.base.app.backoffice.console.presentation.agvManager.AGVManagerUI;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.app.backoffice.console.presentation.product.NewProductUI;
import eapli.base.app.backoffice.console.presentation.product.SearchProductsUI;
import eapli.base.app.backoffice.console.presentation.productsCategory.NewProductsCategoryUI;
import eapli.base.app.backoffice.console.presentation.questionnaire.CheckQuestionnaireUI;
import eapli.base.app.backoffice.console.presentation.questionnaire.CreateQuestionnaireAction;
import eapli.base.app.backoffice.console.presentation.questionnaire.StatisticalReportUI;
import eapli.base.app.backoffice.console.presentation.questionnaire.ValidateQuestionnaireUI;
import eapli.base.app.backoffice.console.presentation.shoppingCart.CreateShoppingCartUI;
import eapli.base.app.backoffice.console.presentation.warehouse.*;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    // WAREHOUSE EMPLOYEE STUFF
    private static final int UPLOAD_WAREHOUSE_PLANT_JSON = 1;
    private static final int CONFIGURE_AGV = 2;
    private static final int SHOW_WAREHOUSE_PLANT = 3;
    private static final int GIVE_ORDER_TO_AGV = 4;
    private static final int CHANGE_ORDER_STATUS_TO_DISPATCHED = 5;
    private static final int OPEN_WEB_WAREHOUSE = 6;
//    private static final int DISH_TYPE_ACTIVATE_DEACTIVATE_OPTION = 4;

    // DISHES
//    private static final int DISH_REGISTER_OPTION = 5;
//    private static final int DISH_LIST_OPTION = 6;
//    private static final int DISH_REGISTER_DTO_OPTION = 7;
//    private static final int DISH_LIST_DTO_OPTION = 8;
//    private static final int DISH_ACTIVATE_DEACTIVATE_OPTION = 9;
//    private static final int DISH_CHANGE_OPTION = 10;

    // DISH PROPERTIES
//    private static final int CHANGE_DISH_NUTRICIONAL_INFO_OPTION = 1;
//    private static final int CHANGE_DISH_PRICE_OPTION = 2;

    // MATERIALS
//    private static final int MATERIAL_REGISTER_OPTION = 1;
//    private static final int MATERIAL_LIST_OPTION = 2;

    // REPORTING
//    private static final int REPORTING_DISHES_PER_DISHTYPE_OPTION = 1;
//    private static final int REPORTING_HIGH_CALORIES_DISHES_OPTION = 2;
//    private static final int REPORTING_DISHES_PER_CALORIC_CATEGORY_OPTION = 3;

    // MEALS
//    private static final int LIST_MEALS_OPTION = 1;
//    private static final int MEAL_REGISTER_OPTION = 2;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;
    private static final int WAREHOUSE_SETTINGS = 5;
    private static final int AGV_MANAGER_MENU = 10;
//    private static final int TRACEABILITY_OPTION = 6;
//    private static final int MEALS_OPTION = 7;
//    private static final int REPORTING_DISHES_OPTION = 8;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }


        //TODO temos de fazer isto para cada us
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_CLERK)) {
            final Menu usersMenu = buildSalesClerkMenu();
            mainMenu.addSubMenu(3, usersMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.WAREHOUSE_EMPLOYEE)) {
            final Menu warehouseMenu = buildWarehouseEmployeeMenu();
            mainMenu.addSubMenu(WAREHOUSE_SETTINGS, warehouseMenu);
            //mudar para 2 em vez de ter o 5 como opção

        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.SALES_MANAGER)) {
            final Menu usersMenu = buildSalesManagerMenu();
            mainMenu.addSubMenu(7, usersMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.AGV_MANAGER)) {
            final Menu agvManagerMenu = buildAGVManagerMenu();
            mainMenu.addSubMenu(AGV_MANAGER_MENU, agvManagerMenu);
            //mudar para 2 em vez de ter o 5 como opção

        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CLIENT_USER)) {
            final Menu usersMenu = buildCustomerMenu();

            mainMenu.addSubMenu(6, usersMenu);

        }


        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));


        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }


    private Menu buildSalesClerkMenu() {
        final Menu menu = new Menu("Sales Clerk Menu:");

        menu.addItem(1, "Create a new Products Category", new NewProductsCategoryUI()::show);
        menu.addItem(2, "Search Products", new SearchProductsUI()::show);
        menu.addItem(3, "Register a new costumer", new RegisterCostumerUI()::show);
        menu.addItem(4, "Register a new product", new NewProductUI()::show);
        menu.addItem(5, "Register a new Costumer Order", new RegisterCostumerOrderUI()::show);
        menu.addItem(6,"Change Order Status to Delivered", new ChangeOrderStatusToBeingDeliveredUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }


    private Menu buildWarehouseEmployeeMenu() {
        final Menu menu = new Menu("Warehouse Menu: ");

        menu.addItem(UPLOAD_WAREHOUSE_PLANT_JSON, "Upload/Update warehouse plant", new WarehouseUploadUI()::show);
        menu.addItem(CONFIGURE_AGV, "AGV Configuration", new AGVConfigurationUI()::show);
        menu.addItem(SHOW_WAREHOUSE_PLANT, "Show warehouse plant", new ShowWarehousePlantUI()::show);
        menu.addItem(GIVE_ORDER_TO_AGV, "Give Order to AGV", new GiveOrderToAGVUI()::show);
        menu.addItem(CHANGE_ORDER_STATUS_TO_DISPATCHED, "Change Order Status to Dispatched", new ChangeOrderStatusUI()::show);
        menu.addItem(OPEN_WEB_WAREHOUSE, "Open web for warehouse", new OpenWebWarehouseUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildAGVManagerMenu() {
        final Menu menu = new Menu("AGV Manager Menu: ");
        menu.addItem(1, "Set AGV Task", new AGVManagerUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCustomerMenu() {

        final Menu menu = new Menu("Customer Menu > ");

        menu.addItem(1, "View products catalog;", new CreateShoppingCartUI()::show);
        menu.addItem(2,"Check my open orders", new CheckStatusOpenOrdersUI()::show);
        menu.addItem(3,"Check Questionnaire", new CheckQuestionnaireUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSalesManagerMenu() {

        final Menu menu = new Menu("Sales Manager Menu > ");

        menu.addItem(1, "Create a new Questionnaire: ", new CreateQuestionnaireAction());
        menu.addItem(2, "Validate a Questionnaire: ", new ValidateQuestionnaireUI()::show);
        menu.addItem(3, "Statistical Report: ", new StatisticalReportUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }





}

