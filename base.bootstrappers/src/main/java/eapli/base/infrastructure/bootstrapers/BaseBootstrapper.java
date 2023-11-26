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
package eapli.base.infrastructure.bootstrapers;

import eapli.base.agvConfiguration.application.AGVConfigurationController;
import eapli.base.agvConfiguration.domain.*;
import eapli.base.costumermanagement.application.RegisterCostumerController;
import eapli.base.costumermanagement.domain.*;
import eapli.base.plantmanagment.application.WarehouseUploadController;
import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.Accessibility;
import eapli.base.plantmanagment.domain.Begin;
import eapli.base.plantmanagment.domain.IDagvDocks;
import eapli.base.plantmanagment.repository.WarehousePlantRepository;
import eapli.base.product.application.NewProductController;
import eapli.base.product.domain.*;
import eapli.base.productOrderManagement.application.RegisterCostumerOrderController;
import eapli.base.productOrderManagement.domain.Item;
import eapli.base.productOrderManagement.domain.ProductOrder;
import eapli.base.productOrderManagement.domain.Shipment;
import eapli.base.productsCategory.application.NewProductsCategoryController;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.Description;
import eapli.base.productsCategory.domain.ProductsCategory;
import eapli.base.questionnaires.application.CreateQuestionnaireController;
import eapli.base.questionnaires.domain.Question;
import eapli.base.questionnaires.domain.Section;
import eapli.base.shoppingCart.application.NewShoppingCartController;
import eapli.base.shoppingCart.domain.ShoppingCart;
import eapli.framework.general.domain.model.Money;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.time.util.Calendars;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.strings.util.Strings;
import eapli.framework.validations.Invariants;

import javax.persistence.Persistence;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Base Bootstrapping data app
 *
 * @author Paulo Gandra de Sousa
 */
@SuppressWarnings("squid:S106")
public class BaseBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            BaseBootstrapper.class);

    private static final String POWERUSER_A1 = "poweruserA1";
    private static final String POWERUSER = "poweruser";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
    private final UserRepository userRepository = PersistenceContext.repositories().users();


    @Override
    public boolean execute() {
        // declare bootstrap actions
        final Action[] actions = {new MasterUsersBootstrapper(),};

        registerPowerUser();
        authenticateForBootstrapping();
        registerCostumer();
        registerProductAndCategory();
        uploadWareHousePlant();
        registerAGV1();
        registerAGV2();
        registerAGV3();
        registerAGV4();
        uploadWareHousePlant();
        //registerOrder();
        //registerShoppingCart();

        // execute all bootstrapping
        boolean ret = true;
        for (final Action boot : actions) {
            System.out.println("Bootstrapping " + nameOfEntity(boot) + "...");
            ret &= boot.execute();
        }
        return ret;
    }

    /**
     * register a power user directly in the persistence layer as we need to
     * circumvent authorisations in the Application Layer
     */
    private boolean registerPowerUser() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername(POWERUSER).withPassword(POWERUSER_A1).withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.POWER_USER);
        final SystemUser newUser = userBuilder.build();

        SystemUser poweruser;
        try {
            poweruser = userRepository.save(newUser);
            assert poweruser != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", newUser.username());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }

    private void registerCostumer() {
        RegisterCostumerController registerCostumerController = new RegisterCostumerController();

        Name nome = new Name("Ze Pessegos");
        PhoneNumber phoneNumber = new PhoneNumber("+351912123456");
        VAT vat = new VAT("PT123456789");
        Email email = new Email("1202016@isep.ipp.pt");
        Address address = new Address("Rua da Loladas", 45, "4475-999", "Porto", "Portugal");
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        String username1 = "lolada";
        String password1 = "Oculto1";
        Set<Role> role1 = new HashSet<>();
        role1.add(BaseRoles.CLIENT_USER);

        Name nome2 = new Name("Ze Pessego");
        PhoneNumber phoneNumber2 = new PhoneNumber("+351912365987");
        VAT vat2 = new VAT("PT123456697");
        Email email2 = new Email("1202017@isep.ipp.pt");
        Address address2 = new Address("Rua da Pecados", 68, "4475-698", "Lousada", "Irlanda");
        Set<Address> addressSet2 = new HashSet<>();
        addressSet.add(address2);
        String username2 = "incrivel";
        String password2 = "Oculto1";
        Set<Role> role2 = new HashSet<>();
        role2.add(BaseRoles.CLIENT_USER);

        registerCostumerController.registerCostumer(nome, phoneNumber, vat,
                email, addressSet, null, null,username1,password1, role1);
        registerCostumerController.registerCostumer(nome2,phoneNumber2,vat2,email2,addressSet2,null,null, username2, password2,role2);
    }


    private void uploadWareHousePlant(){
        WarehouseUploadController controller = new WarehouseUploadController();
        controller.createPlant("warehouse1",true);

    }






    private void registerProductAndCategory() {

        NewProductsCategoryController catController = new NewProductsCategoryController();
        NewProductController productController = new NewProductController();



        AlphanumericCode code = new AlphanumericCode("45sa5");
        Description description = new Description("        Sapatilhas          ");
        catController.newProductsCategory(code, description);
        InternalCode internalCode = new InternalCode("12354a");
        ShortDescription shortDescription = new ShortDescription("sapatilhas de marca numero 40");
        ExtendedDescription extendedDescription = new ExtendedDescription("sapatilhas pretas com logo branco" +
                "de marca nike");
        Barcode barcode = new Barcode(123456789321L,Product.TYPE.UPC);
        Money without = Money.euros(20.2);
        Money with = Money.euros(23.0);
        double weight = 3.0;
        double volume = 35.0;
        Brand brand1 = new Brand("nike");
        ProductsCategory cat = new ProductsCategory(code,description);
        ProductLocation productLocation1 = new ProductLocation(20,45,12);

        productController.newProduct(internalCode,shortDescription,extendedDescription,null,brand1,
                null,null,barcode,null,without,with,weight,volume,cat,productLocation1,true);




        AlphanumericCode code2 = new AlphanumericCode("ada7884");
        Description description2 = new Description("         Bebidas         " );
        catController.newProductsCategory(code2,description2);
        InternalCode internalCode2 = new InternalCode("789sa");
        ShortDescription shortDescription2 = new ShortDescription("caixa de cerveja");
        ExtendedDescription extendedDescription2 = new ExtendedDescription("caixa de cerveja SuperBock" +
                "24x0.33l");
        Barcode barcode2 = new Barcode(7894561234558L,Product.TYPE.EAN13);
        Money without2 = Money.euros(19.2);
        Money with2 = Money.euros(24.0);
        double weight2 = 20.0;
        double volume2 = 45.0;
        Brand brand2 = new Brand("SuperBock");
        ProductsCategory cat2 = new ProductsCategory(code2,description2);
        ProductLocation productLocation2 = new ProductLocation(1,1,3);

        productController.newProduct(internalCode2,shortDescription2,extendedDescription2,null,brand2,
                null,null,barcode2,null,without2,with2,weight2,volume2,cat2,productLocation2,false);






        InternalCode internalCode3 = new InternalCode("8u6a");
        ShortDescription shortDescription3 = new ShortDescription("sapatilhas de marca numero 42");
        ExtendedDescription extendedDescription3 = new ExtendedDescription("sapatilhas vermelhas e brancas" +
                "da marca Gucci");
        Barcode barcode3 = new Barcode(123456789123L,Product.TYPE.UPC);
        Money without3 = Money.euros(100.2);
        Money with3 = Money.euros(120.0);
        double weight3 = 5.0;
        double volume3 = 40.0;
        Brand brand3 = new Brand("Gucci");
        ProductLocation productLocation3 = new ProductLocation(2,2,3);

        productController.newProduct(internalCode3,shortDescription3,extendedDescription3,null,brand3,
                null,null,barcode3,null,without3,with3,weight3,volume3,cat,productLocation3,false);






        InternalCode internalCode4 = new InternalCode("35b6a");
        ShortDescription shortDescription4 = new ShortDescription("sapatilhas de marca numero 44");
        ExtendedDescription extendedDescription4 = new ExtendedDescription("sapatilhas brancas" +
                "da marca reebook");
        Barcode barcode4 = new Barcode(321456789123L,Product.TYPE.UPC);
        Money without4 = Money.euros(45.2);
        Money with4 = Money.euros(51.0);
        double weight4 = 4.0;
        double volume4 = 43.0;
        Brand brand4 = new Brand("Reebook");
        ProductLocation productLocation4 = new ProductLocation(3,1,2);

        productController.newProduct(internalCode4,shortDescription4,extendedDescription4,null,brand4,
                null,null,barcode4,null,without4,with4,weight4,volume4,cat,productLocation4,false);


    }

    private void registerOrder(){
        RegisterCostumerOrderController orderController = new RegisterCostumerOrderController();
        Set<Item> itemList = new HashSet<>();
        Item item = new Item("124",4);
        itemList.add(item);

        Address address = new Address("Rua da Loladas", 45, "4475-999", "Porto", "Portugal");

        Address address1 = new Address("Rua da Pecados", 68, "4475-698", "Lousada", "Irlanda");

        ///////////////////

        Set<Item> itemList2 = new HashSet<>();
        Item item1 = new Item("12354a", 2);
        Item item2 = new Item("12354a",1);
        itemList2.add(item1);
        itemList2.add(item2);

        Address address2 = new Address("Rua das ruas", 12, "4471-541", "Lisboa","Italia");
        Address address3 = new Address("Rua das pontes", 14, "5741-114","Valongo","Antartida");

        orderController.registerOrder(itemList,address,address1,Shipment.STANDARD, ProductOrder.CommunicationMethod.EMAIL,Calendars.now(), ProductOrder.PaymentMethod.APPLEPAY);
        orderController.registerOrder(itemList2,address2,address3, Shipment.BLUE,ProductOrder.CommunicationMethod.CALL,Calendars.now(), ProductOrder.PaymentMethod.PAYPAL);
    }



    private void registerAGV1() {


        AGVConfigurationController controller = new AGVConfigurationController();

        Id id = new Id("1234");
        MaxVolume mV = new MaxVolume(54.02);
        MaxWeight mW = new MaxWeight(54.02);
        ShortDescription sD = new ShortDescription("ze manel dos produtos");
        Model m = new Model("La Ferrari");
        AGV.Status s = AGV.Status.FREE;
        Route r = new Route(1);
        Autonomy a2 = new Autonomy("5 hours");
        Task t = new Task("deliver product");

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(1L);
        arrayList.add(3L);
        arrayList.add(1L);
        arrayList.add(3L);
        arrayList.add(1L);
        arrayList.add(3L);
        AGVDocks iDagvDocks =  new AGVDocks(new IDagvDocks("D1"),arrayList, new Accessibility("l+"));


        controller.newAGVConfiguration(id,mW,mV,m,r,sD,s,a2,t,iDagvDocks);
    }

    private void registerAGV2() {


        AGVConfigurationController controller = new AGVConfigurationController();

        Id id = new Id("2345");
        MaxVolume mV = new MaxVolume(40.02);
        MaxWeight mW = new MaxWeight(47.02);
        ShortDescription sD = new ShortDescription("manuela dos carregos");
        Model m = new Model("Mercedes-amg GT");
        AGV.Status s = AGV.Status.FREE;
        Route r = new Route(2);
        Autonomy a2 = new Autonomy("7 hours");
        Task t = new Task("deliver product");

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(1L);
        arrayList.add(3L);
        arrayList.add(1L);
        arrayList.add(3L);
        arrayList.add(1L);
        arrayList.add(3L);
        AGVDocks iDagvDocks =  new AGVDocks(new IDagvDocks("D2"),arrayList, new Accessibility("l+"));


        controller.newAGVConfiguration(id,mW,mV,m,r,sD,s,a2,t,iDagvDocks);
    }

    private void registerAGV3() {


        AGVConfigurationController controller = new AGVConfigurationController();

        Id id = new Id("3456");
        MaxVolume mV = new MaxVolume(45.38);
        MaxWeight mW = new MaxWeight(35.40);
        ShortDescription sD = new ShortDescription("bob das constructions");
        Model m = new Model("Mustang");
        AGV.Status s = AGV.Status.FREE;
        Route r = new Route(3);
        Autonomy a2 = new Autonomy("6 hours");
        Task t = new Task("deliver product");

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(1L);
        arrayList.add(3L);
        arrayList.add(1L);
        arrayList.add(3L);
        arrayList.add(1L);
        arrayList.add(3L);
        AGVDocks iDagvDocks =  new AGVDocks(new IDagvDocks("D3"),arrayList, new Accessibility("l+"));


        controller.newAGVConfiguration(id,mW,mV,m,r,sD,s,a2,t,iDagvDocks);
    }

    private void registerAGV4() {


        AGVConfigurationController controller = new AGVConfigurationController();

        Id id = new Id("4567");
        MaxVolume mV = new MaxVolume(60.78);
        MaxWeight mW = new MaxWeight(58.46);
        ShortDescription sD = new ShortDescription("carregado até aos cotos");
        Model m = new Model("Supra");
        AGV.Status s = AGV.Status.FREE;
        Route r = new Route(4);
        Autonomy a2 = new Autonomy("6 hours");
        Task t = new Task("deliver product");

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(1L);
        arrayList.add(3L);
        arrayList.add(1L);
        arrayList.add(3L);
        arrayList.add(1L);
        arrayList.add(3L);
        AGVDocks iDagvDocks =  new AGVDocks(new IDagvDocks("D4"),arrayList, new Accessibility("l+"));


        controller.newAGVConfiguration(id,mW,mV,m,r,sD,s,a2,t,iDagvDocks);
    }







    private void resgisterQuestionnaire() throws IOException {
        CreateQuestionnaireController ctr = new CreateQuestionnaireController();

//        int id = 0;
//        String title= "Questionario Base";
//        String welcomeMess= "Bem vindo";
//        List<Section> sectionList =  new ArrayList<>();
//        List<Question> questionList =  new ArrayList<>();
//        int sectioId = 1;
//        String sectionTitle= "Grupo 1";
//        String sectDescrip = "food";
//        String sectObligt = "optional";
//        int sectionRepeat = 1;
//
//        int questionType = 1;
//        int questionId = 1;
//        String quest = "qual a sua comida preferida?";
//        String questInstr = "";
//        String questOblit= "dependent";
//        String questInfo= "no info";
//
//        String finalMess= "thank iu";
//
//        questionList.add(ctr.buildQuestion(questionType,questionId,quest,questInstr,questOblit,questInfo));
//        sectionList.add(ctr.buildSection(sectioId,sectionTitle,sectDescrip,sectObligt,sectionRepeat,questionList));
//
//
//        ctr.createQuestionnaire(id,title,welcomeMess,sectionList,finalMess);
        ctr.saveQuestionnaireString("D:\\Users\\User\\Documentos\\lei21_22_s4_2df_03\\docs\\SPRINT_C\\SpecifyGrammar\\QuestionnaireExamples\\questionnaire 3.txt");
        ctr.saveQuest("D:\\Users\\User\\Documentos\\lei21_22_s4_2df_03\\docs\\SPRINT_C\\SpecifyGrammar\\QuestionnaireExamples\\questionnaire 3.txt");
    }

    /*private void registerShoppingCart() {

        NewShoppingCartController shoppingCartController = new NewShoppingCartController();


        Set<Item> products = new HashSet<>();

        //ShoppingCart cart = new ShoppingCart(costumer,products,authz.session().get().authenticatedUser());


        shoppingCartController.createShoppingCart(costumer,products);



    }*/

    /**
     * authenticate a super user to be able to register new users
     */
    protected void authenticateForBootstrapping() {
        authenticationService.authenticate(POWERUSER, POWERUSER_A1);
        Invariants.ensure(authz.hasSession());
    }

    private String nameOfEntity(final Action boot) {
        final String name = boot.getClass().getSimpleName();
        return Strings.left(name, name.length() - "Bootstrapper".length());
    }
}
