package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.ObjectReader;

import java.util.ArrayList;

public class main {
    //Test class
    public static void main(String[] args) {
        Admin admin1 = new Admin("Admin1", "Admin1Pass");
        Admin admin2 = new Admin("Admin2", "Admin2Pass");
        Admin admin3 = new Admin("Admin3", "Admin3Pass");
        System.out.println("Write to file using ObjectWriter");
        admin1.write();
        admin2.write();
        admin3.write();
        ArrayList<Object> adminList = ObjectReader.readObject(ObjectReader.Type.ADMIN);
        System.out.println("Read from file using ObjectReader");
        System.out.println(adminList);
        System.out.println("Print single admin object");
        System.out.println(adminList.get(0));
        System.out.println(adminList.get(2));


        System.out.println("Create objects and print:");
        Producer producer = new Producer("producer", "producerpass");
        System.out.println(producer);

        Production production = new Production("production", 1);
        System.out.println(production);

        Person person = new Person("person", 1, "person@person.dk");
        System.out.println(person);

        Credit credit = new Credit(person.getPersonID(), production.getProductionID(), "somerole");
        System.out.println(credit);

        System.out.println("\nWrite  objects to files and read again");
        producer.write();
        production.write();
        person.write();
        credit.write();

        //System.out.println(ObjectReader.readObject(ObjectReader.Type.ADMIN));
        System.out.println(ObjectReader.readObject(ObjectReader.Type.PRODUCER));
        System.out.println(ObjectReader.readObject(ObjectReader.Type.PRODUCTION));
        System.out.println(ObjectReader.readObject(ObjectReader.Type.PERSON));
        System.out.println(ObjectReader.readObject(ObjectReader.Type.CREDIT));

    }
}
