package eapli.base.agvConfiguration.domain;

import eapli.base.plantmanagment.domain.AGVDocks;
import eapli.base.plantmanagment.domain.Accessibility;
import eapli.base.plantmanagment.domain.IDagvDocks;
import eapli.base.productsCategory.domain.AlphanumericCode;
import eapli.base.productsCategory.domain.Description;
import eapli.base.productsCategory.domain.ProductsCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AGVTest {

//    @Test
//    void testToString() {
//        Id id = new Id("1234");
//        MaxVolume mV = new MaxVolume(54.02);
//        MaxWeight mW = new MaxWeight(54.02);
//        ShortDescription sD = new ShortDescription("ze manel dos produtos");
//        Model m = new Model("ze manel dos produtos é o melhor sales clerk");
//        Status s = new Status("charging");
//        Route r = new Route(1);
//        Autonomy a2 = new Autonomy("5 hours");
//        Task t = new Task("charging");
//        IDagvDocks ida = new IDagvDocks("D01");
//        ArrayList<Long>
//        Accessibility accessibility = new Accessibility("l+");
//        AGVDocks agvDocks = new AGVDocks(ida,,accessibility);
//        AGV a = new AGV();
////        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a2, t);
//        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a2, t,ida);
//        Assertions.assertNotEquals(a1.toString(), a.toString());
//    }
//
//    @Test
//    void testToString2() {
//        Id id = new Id("1234");
//        MaxVolume mV = new MaxVolume(54.02);
//        MaxWeight mW = new MaxWeight(54.02);
//        ShortDescription sD = new ShortDescription("ze manel dos produtos");
//        Model m = new Model("ze manel dos produtos é o melhor sales clerk");
//        Status s = new Status("charging");
//        Route r = new Route(1);
//        Autonomy a = new Autonomy("5 hours");
//        Task t = new Task("charging");
//        IDagvDocks ida = new IDagvDocks("D01");
////        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t);
//        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t,ida);
//        String expected = "AGV-> id: 1234;\n" +
//                "\tmaxVolume= 54.02;\n" +
//                "\tmaxWeight= 54.02;\n" +
//                "\tmodel: ze manel dos produtos é o melhor sales clerk;\n" +
//                "\troute: 1;\n" +
//                "\tshortDescription: ze manel dos produtos;\n" +
//                "\tstatus: charging;\n" +
//                "\tautonomy: 5 hours;\n" +
//                "\ttask: charging;\n\t";
//
////        String expected = "AGV-> id: 1234;\n" +
////                "\tmaxVolume= 54.02;\n" +
////                "\tmaxWeight= 54.02;\n" +
////                "\tmodel: ze manel dos produtos é o melhor sales clerk;\n" +
////                "\troute: 1;\n" +
////                "\tshortDescription: ze manel dos produtos;\n" +
////                "\tstatus: charging;\n" +
////                "\tautonomy: 5 hours;\n" +
////                "\ttask: charging;\n\t"+"agvDockID: D01;\n";
//        Assertions.assertEquals(a1.toString(), expected);
//    }
//
//    @Test
//    void sameAs() {
//        Id id = new Id("1234");
//        MaxVolume mV = new MaxVolume(54.02);
//        MaxWeight mW = new MaxWeight(54.02);
//        ShortDescription sD = new ShortDescription("ze manel dos produtos");
//        Model m = new Model("ze manel dos produtos é o melhor sales clerk");
//        Status s = new Status("charging");
//        Route r = new Route(1);
//        Autonomy a = new Autonomy("5 hours");
//        Task t = new Task("charging");
//        IDagvDocks ida = new IDagvDocks("D01");
////        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t);
////        Object a2 = new AGV(id, mW, mV, m, r, sD, s, a, t);
//        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t,ida);
//        Object a2 = new AGV(id, mW, mV, m, r, sD, s, a, t,ida);
//        Assertions.assertTrue(a1.sameAs(a2));
//    }
//
//    @Test
//    void sameAs2() {
//        Id id = new Id("1234");
//        MaxVolume mV = new MaxVolume(54.02);
//        MaxWeight mW = new MaxWeight(54.02);
//        ShortDescription sD = new ShortDescription("ze manel dos produtos");
//        Model m = new Model("ze manel dos produtos é o melhor sales clerk");
//        Status s = new Status("charging");
//        Route r = new Route(1);
//        Autonomy a = new Autonomy("5 hours");
//        AlphanumericCode ac = new AlphanumericCode("1324");
//        Description c = new Description("da lhe serginho na queima");
//        Task t = new Task("charging");
//        IDagvDocks ida = new IDagvDocks("D01");
//
////        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t);
//        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t,ida);
//        Object a2 = new ProductsCategory(ac, c);
//        Assertions.assertFalse(a1.sameAs(a2));
//    }
//
//
//    @Test
//    void identity() {
//        Id id = new Id("1234");
//        MaxVolume mV = new MaxVolume(54.02);
//        MaxWeight mW = new MaxWeight(54.02);
//        ShortDescription sD = new ShortDescription("ze manel dos produtos");
//        Model m = new Model("ze manel dos produtos é o melhor sales clerk");
//        Status s = new Status("charging");
//        Route r = new Route(1);
//        Autonomy a = new Autonomy("5 hours");
//        Task t = new Task("charging");
//        IDagvDocks ida = new IDagvDocks("D01");
////        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t);
////        AGV a2 = new AGV(id, mW, mV, m, r, sD, s, a, t);
//        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t,ida);
//        AGV a2 = new AGV(id, mW, mV, m, r, sD, s, a, t,ida);
//        Assertions.assertEquals(a1.identity(), a2.identity());
//    }
//
//    @Test
//    void identity2() {
//        Id id = new Id("1234");
//        Id id2 = new Id("12ere34");
//        MaxVolume mV = new MaxVolume(54.02);
//        MaxWeight mW = new MaxWeight(54.02);
//        ShortDescription sD = new ShortDescription("ze manel dos produtos");
//        Model m = new Model("ze manel dos produtos é o melhor sales clerk");
//        Status s = new Status("charging");
//        Route r = new Route(1);
//        Autonomy a = new Autonomy("5 hours");
//        Task t = new Task("charging");
//        IDagvDocks ida = new IDagvDocks("D01");
////        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t);
////        AGV a2 = new AGV(id2, mW, mV, m, r, sD, s, a, t);
//        AGV a1 = new AGV(id, mW, mV, m, r, sD, s, a, t, ida);
//        AGV a2 = new AGV(id2, mW, mV, m, r, sD, s, a, t, ida);
//        Assertions.assertNotEquals(a1.identity(), a2.identity());
//    }
}