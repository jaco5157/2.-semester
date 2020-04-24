package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;

import java.util.ArrayList;

import static dk.sdu.tek.persistence.ObjectReader.Type.*;

public class main {
    //Test class
    public static void main(String[] args) {
//        Admin admin1 = new Admin("Admin1", "Admin1Pass");
//        Admin admin2 = new Admin("Admin2", "Admin2Pass");
//        Admin admin3 = new Admin("Admin3", "Admin3Pass");
//        System.out.println("Write to file using ObjectWriter");
//        admin1.write();
//        admin2.write();
//        admin3.write();
//        ArrayList<Object> adminList = ObjectReader.readObject(ObjectReader.Type.ADMIN);
//        System.out.println("Read from file using ObjectReader");
//        System.out.println(adminList);
//        System.out.println("Print single admin object");
//        System.out.println(adminList.get(0));
//        System.out.println(adminList.get(2));
//
//
//        System.out.println("Create objects and print:");
//        Producer producer = new Producer("producer", "producerpass");
//        System.out.println(producer);
//
//        Production production = new Production("production", 1);
//        System.out.println(production);
//
//        Person person = new Person("person", 1, "person@person.dk");
//        System.out.println(person);
//
//        Credit credit = new Credit(person.getPersonID(), production.getProductionID(), "somerole");
//        System.out.println(credit);
//
//        System.out.println("\nWrite  objects to files and read again");
//        producer.write();
//        production.write();
//        person.write();
//        credit.write();
//
//        //System.out.println(ObjectReader.readObject(ObjectReader.Type.ADMIN));
//        System.out.println(ObjectReader.readObject(ObjectReader.Type.PRODUCER));
//        System.out.println(ObjectReader.readObject(ObjectReader.Type.PRODUCTION));
//        System.out.println(ObjectReader.readObject(ObjectReader.Type.PERSON));
//        System.out.println(ObjectReader.readObject(ObjectReader.Type.CREDIT));

//        Production production1 = new Production("production1", 1,1);
//        Production production2 = new Production("production2", 2,1);
//        Production production3 = new Production("production3", 3,1);
//        System.out.println("Printing credits for production 1:");
//        ArrayList<Credit> production1credits = production1.getCredits();
//        for (Credit credit : production1credits) {
//            System.out.println(credit);
//        }

        Person person = new Person("person2", 2, "person2@person.dk");
        Producer producer = new Producer("username2", "password2",2);
        Production production = new Production("prodname2", 2, 2);
        Credit credit = new Credit(person.getPersonID(), production.getProductionID(), "somerole2");
        producer.write();
        production.write();
        person.write();
        credit.write();
        Admin admin = new Admin("admin","password");
        Admin admin2 = new Admin("admin2","password2");
        Admin admin3 = new Admin("admin3","password3");
        admin.write();
        admin2.write();
        admin3.write();

        System.out.println("Admins: ");
        System.out.println(ObjectReader.readObject(ADMIN));

        System.out.println("\nProducers: ");
        System.out.println(ObjectReader.readObject(PRODUCER));

        System.out.println("\nProductions: ");
        System.out.println(ObjectReader.readObject(PRODUCTION));

        System.out.println("\nCredits: ");
        System.out.println(ObjectReader.readObject(CREDIT));

        System.out.println("\nPeople: ");
        System.out.println(ObjectReader.readObject(PERSON));


    }
}
