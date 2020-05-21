package dk.sdu.tek.domain;

import java.sql.*;

public class main {
    static Connection connection = null;
    //Test class
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/creditSystem",
                    "postgres",
                    "adminSQL");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Indsæt data
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO admins (username, password) VALUES (?,?)");
            insertStatement.setString(1, "anders");
            insertStatement.setString(2, "123");
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Hent data ud
        try {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM admins");
            ResultSet queryResultSet = queryStatement.executeQuery();
            while (queryResultSet.next()){
                System.out.println(queryResultSet.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


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





//        System.out.println("Admins: ");
//        System.out.println(ObjectReader.readObject(ADMIN));
//
//        System.out.println("\nProducers: ");
//        System.out.println(ObjectReader.readObject(PRODUCER));
//
//        System.out.println("\nProductions: ");
//        System.out.println(ObjectReader.readObject(PRODUCTION));
//
//        System.out.println("\nCredits: ");
//        System.out.println(ObjectReader.readObject(CREDIT));
//
//        System.out.println("\nPeople: ");
//        System.out.println(ObjectReader.readObject(PERSON));
//
//        ArrayList<Person> peoplesssss = ObjectReader.readObject(PERSON);
//        for (Person people : peoplesssss) {
//            System.out.println(people);
//        }
//        Admin admin = new Admin(1,"1", "1");
//        PersistenceHandler.getInstance().createAdmin(admin);
//        System.out.println(PersistenceHandler.getInstance().getAdmins());
//        Credit credit = new Credit();
//        new Producer(1, "producer1", "pw").write();
//        new Producer(2, "producer2", "pw").write();
//        new Producer(3, "producer3", "pw").write();
//        new Production(1, "Badehotellet", 1).write();
//        new Production(2, "X Factor", 1).write();
//        new Production(3, "Produktion 3", 2).write();
//        new Production(4, "Produktion 4", 3).write();
//        new Person(1, "Name 1", "name1@person.dk").write();
//        new Person(2, "Name 2", "name2@person.dk").write();
//        new Person(3, "Name 3", "name3@person.dk").write();
//        new Person(4, "Name 4", "name4@person.dk").write();
//        new Credit(1, 1, 1, "Some role").write();
//        new Credit(5, 2, 1, "Some role 2").write();
//        new Credit(2, 2, 2, "Some role").write();
//        new Credit(3, 3, 3, "Some role").write();
//        new Credit(4, 4, 4, "Some role").write();

    }
}
