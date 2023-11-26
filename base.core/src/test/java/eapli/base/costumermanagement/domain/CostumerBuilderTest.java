package eapli.base.costumermanagement.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CostumerBuilderTest {

    @Test
    void named() {
        Name name = new Name("suao alberto");
        Name name2 = new Name("sua3o josue");
        CostumerBuilder c = new CostumerBuilder();
        CostumerBuilder c2 = new CostumerBuilder();
        Assertions.assertNotEquals(c.named(name), c2.named(name2));
    }

    @Test
    void withPhoneNumber() {
        PhoneNumber name = new PhoneNumber("918545269");
        PhoneNumber name2 = new PhoneNumber("936584125");
        CostumerBuilder c = new CostumerBuilder();
        CostumerBuilder c2 = new CostumerBuilder();
        Assertions.assertNotEquals(c.withPhoneNumber(name), c2.withPhoneNumber(name2));
    }

    @Test
    void withVat() {
        VAT name = new VAT("PT123456789");
        VAT name2 = new VAT("CY123456789");
        CostumerBuilder c = new CostumerBuilder();
        CostumerBuilder c2 = new CostumerBuilder();
        Assertions.assertNotEquals(c.withVat(name), c2.withVat(name2));
    }

    @Test
    void withEmail() {
        Email name = new Email("zedascoibes@gmail.com");
        Email name2 = new Email("naoeosuaodascoibes@gmail.com");
        CostumerBuilder c = new CostumerBuilder();
        CostumerBuilder c2 = new CostumerBuilder();
        Assertions.assertNotEquals(c.withEmail(name), c2.withEmail(name2));
    }


    @Test
    void withAddresses() {
        Address name = new Address("rua da coibes",5,"4754-887","porto","portugal");
        Address name2 = new Address("rua da coibes",5,"4754-879","porto","portugal");
        Set<Address> a = new HashSet<>();
        Set<Address> a2 = new HashSet<>();
        a.add(name2);
        a2.add(name);
        CostumerBuilder c = new CostumerBuilder();
        CostumerBuilder c2 = new CostumerBuilder();

        Costumer co = new CostumerBuilder().named(new Name("joaquim alberto"))
                .withPhoneNumber(new PhoneNumber("918547595"))
                .withVat(new VAT("PT123456789")).withEmail(new Email("va@gmail.com"))
                .withAddresses(a)
                .withGender(new Gender(2))
                .withBirthdate(new Birthdate("2001-01-15"))
                .build();
        Costumer co1 = new CostumerBuilder().named(new Name("joaquim alberto"))
                .withPhoneNumber(new PhoneNumber("918547595"))
                .withVat(new VAT("PT123456589")).withEmail(new Email("va@gmail.com"))
                .withAddresses(a)
                .withGender(new Gender(2))
                .withBirthdate(new Birthdate("2001-01-15"))
                .build();

        Assertions.assertNotEquals(co, co1);
    }
    @Test
    void withAddresses2() {
        Address name = new Address("rua da coibes",5,"4754-887","porto","portugal");
        Address name2 = new Address("rua da coibes",5,"4754-879","porto","portugal");
        Set<Address> a = new HashSet<>();
        Set<Address> a2 = new HashSet<>();
        a.add(name2);
        a2.add(name);
        CostumerBuilder c = new CostumerBuilder();
        CostumerBuilder c2 = new CostumerBuilder();

        Costumer co = new CostumerBuilder().named(new Name("joaquim alberto"))
                .withPhoneNumber(new PhoneNumber("918547595"))
                .withVat(new VAT("PT123456789")).withEmail(new Email("va@gmail.com"))
                .withAddresses(a)
                .withGender(new Gender(2))
                .withBirthdate(new Birthdate("2001-01-15"))
                .build();
        Costumer co1 = new CostumerBuilder().named(new Name("joaquim alberto"))
                .withPhoneNumber(new PhoneNumber("918547595"))
                .withVat(new VAT("PT123456589")).withEmail(new Email("va@gmail.com"))
                .withAddresses(a)
                .withGender(new Gender(1))
                .withBirthdate(new Birthdate("2001-01-15"))
                .build();

        Assertions.assertNotEquals(co, co1);
    }
    @Test
    void withAddresses3() {
        Address name = new Address("rua da coibes",5,"4754-887","porto","portugal");
        Address name2 = new Address("rua da coibes",5,"4754-879","porto","portugal");
        Set<Address> a = new HashSet<>();
        Set<Address> a2 = new HashSet<>();
        a.add(name2);
        a2.add(name);
        CostumerBuilder c = new CostumerBuilder();
        CostumerBuilder c2 = new CostumerBuilder();

        Costumer co = new CostumerBuilder().named(new Name("joaquim alberto"))
                .withPhoneNumber(new PhoneNumber("918547595"))
                .withVat(new VAT("PT123456789")).withEmail(new Email("va@gmail.com"))
                .withAddresses(a)
                .withGender(new Gender(2))
                .withBirthdate(new Birthdate("2001-01-15"))
                .build();
        Costumer co1 = new CostumerBuilder().named(new Name("joaquim alberto"))
                .withPhoneNumber(new PhoneNumber("918547595"))
                .withVat(new VAT("PT123456589")).withEmail(new Email("va@gmail.com"))
                .withAddresses(a)
                .withGender(new Gender(0))
                .withBirthdate(new Birthdate("2001-01-15"))
                .build();

        Assertions.assertNotEquals(co, co1);
    } @Test
    void withAddresses4() {
        Address name = new Address("rua da coibes",5,"4754-887","porto","portugal");
        Address name2 = new Address("rua da coibes",5,"4754-879","porto","portugal");
        Set<Address> a = new HashSet<>();
        Set<Address> a2 = new HashSet<>();
        a.add(name2);
        a2.add(name);
        CostumerBuilder c = new CostumerBuilder();
        CostumerBuilder c2 = new CostumerBuilder();

        Costumer co = new CostumerBuilder().named(new Name("joaquim alberto"))
                .withPhoneNumber(new PhoneNumber("918547595"))
                .withVat(new VAT("PT123456789")).withEmail(new Email("va@gmail.com"))
                .withAddresses(a)
                .withGender(new Gender(2))
                .withBirthdate(new Birthdate("2001-01-15"))
                .build();
        Costumer co1 = new CostumerBuilder().named(new Name("joaquim alberto"))
                .withPhoneNumber(new PhoneNumber("918547595"))
                .withVat(new VAT("PT123456589")).withEmail(new Email("va@gmail.com"))
                .withAddresses(a)
                .withGender(new Gender(3))
                .withBirthdate(new Birthdate("2001-01-15"))
                .build();

        Assertions.assertNotEquals(co, co1);
    }
//    @Test
//    void withAddresses4() { IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () -> {
//        Address name = new Address("rua da coibes",5,"4754-887","porto","portugal");
//        Address name2 = new Address("rua da coibes",5,"4754-879","porto","portugal");
//        Set<Address> a = new HashSet<>();
//        Set<Address> a2 = new HashSet<>();
//        a.add(name2);
//        a2.add(name);
//        CostumerBuilder c = new CostumerBuilder();
//        CostumerBuilder c2 = new CostumerBuilder();
//        Assertions.assertNotEquals(c, c2);});
//        Assertions.assertEquals("", thrown.getMessage());
//
//    }


}