package dk.sdu.tek.persistence;

import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import dk.sdu.tek.domain.*;
import org.bson.Document;
import org.json.JSONObject;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersistenceHandler implements IPersistenceHandler {

    private static final String URL = "jdbc:postgresql://localhost:5432/creditSystem";
    private static PersistenceHandler instance;
    static Connection connection = null;

    private PersistenceHandler() {
            initializeDatabase();
    }

    public static PersistenceHandler getInstance() {
            if (instance == null) {
                instance = new PersistenceHandler();
            }
            return instance;
    }

    private void initializeDatabase() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    URL,
                    "postgres",
                    "fawerSQL");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Admin> getAdmins() {
        ArrayList<Admin> adminArrayList = new ArrayList();
        try {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM admins");
            ResultSet queryResultSet = queryStatement.executeQuery();
            while (queryResultSet.next()){
                adminArrayList.add(new Admin(queryResultSet.getInt(1),queryResultSet.getString(2),queryResultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return adminArrayList;
        }
    }

    @Override
    public Admin getAdmin(int id) {
        for (Admin admin : this.getAdmins()) {
            if (admin.getId() == id) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public Admin getAdmin(String name) {
        for (Admin admin : this.getAdmins()) {
            if (admin.getUsername().equals(name)) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public boolean createAdmin(Admin admin) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO admins (username, password) VALUES (?,?)");
            insertStatement.setString(1, admin.getUsername());
            insertStatement.setString(2, admin.getPassword());
            insertStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Producer> getProducers() {
        ArrayList<Producer> producerArrayList = new ArrayList();
        try {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM producers");
            ResultSet queryResultSet = queryStatement.executeQuery();
            while (queryResultSet.next()){
                producerArrayList.add(new Producer(queryResultSet.getInt(1),queryResultSet.getString(2),queryResultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return producerArrayList;
        }
    }

    @Override
    public Producer getProducer(int id) {
        for (Producer producer : this.getProducers()) {
            if (producer.getId() == id) {
                return producer;
            }
        }
        return null;
    }

    @Override
    public Producer getProducer(String name) {
        for (Producer producer : this.getProducers()) {
            if (producer.getUsername().equals(name)) {
                return producer;
            }
        }
        return null;
    }

    @Override
    public boolean createProducer(Producer producer) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO producers (username, password) VALUES (?,?)");
            insertStatement.setString(1, producer.getUsername());
            insertStatement.setString(2, producer.getPassword());
            insertStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Production> getProductions() {
        ArrayList<Production> productionArrayList = new ArrayList();
        try {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM productions");
            ResultSet queryResultSet = queryStatement.executeQuery();
            while (queryResultSet.next()){
                productionArrayList.add(new Production(queryResultSet.getInt(1),queryResultSet.getString(2),queryResultSet.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return productionArrayList;
        }
    }

    @Override
    public Production getProduction(int id) {
        for (Production production : this.getProductions()) {
            if (production.getId() == id) {
                return production;
            }
        }
        return null;
    }

    @Override
    public boolean createProduction(Production production) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO productions (name, producer_id) VALUES (?,?)");
            insertStatement.setString(1, production.getName());
            insertStatement.setInt(2, production.getProducerID());
            insertStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Person> getPeople() {
        ArrayList<Person> personArrayList = new ArrayList();
        try {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM person");
            ResultSet queryResultSet = queryStatement.executeQuery();
            while (queryResultSet.next()){
                personArrayList.add(new Person(queryResultSet.getInt(1),queryResultSet.getString(2),queryResultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return personArrayList;
        }
    }

    @Override
    public Person getPerson(int id) {
        for (Person person : this.getPeople()) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public boolean createPerson(Person person) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO person (name, email) VALUES (?,?)");
            insertStatement.setString(1, person.getName());
            insertStatement.setString(2, person.getContactInfo());
            insertStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Credit> getCredits() {
        ArrayList<Credit> creditsArrayList = new ArrayList();
        try {
            PreparedStatement queryStatement = connection.prepareStatement("SELECT * FROM credits");
            ResultSet queryResultSet = queryStatement.executeQuery();
            while (queryResultSet.next()){
                creditsArrayList.add(new Credit(queryResultSet.getInt(1),queryResultSet.getInt(2),queryResultSet.getInt(3),queryResultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return creditsArrayList;
        }
    }

    @Override
    public Credit getCredit(int id) {
        for (Credit credit : this.getCredits()) {
            if (credit.getId() == id) {
                return credit;
            }
        }
        return null;
    }

    @Override
    public boolean createCredit(Credit credit) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO credits (production_id, person_id, role) VALUES (?,?,?)");
            insertStatement.setInt(1, credit.getProductionID());
            insertStatement.setInt(2, credit.getPersonID());
            insertStatement.setString(3, credit.getRole());
            insertStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCredit(int id) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "DELETE from Credits where id = ?");
                           // "INSERT INTO credits (production_id, person_id, role) VALUES (?,?,?)");
            insertStatement.setInt(1, id);
            insertStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean editCredit(int id, Credit credit) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "UPDATE Credits SET production_id = ?, person_id = ?, role = ? WHERE id = ?");
            // "INSERT INTO credits (production_id, person_id, role) VALUES (?,?,?)");
            insertStatement.setInt(1, credit.getProductionID());
            insertStatement.setInt(2, credit.getPersonID());
            insertStatement.setString(3, credit.getRole());
            insertStatement.setInt(4, credit.getId());
            insertStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


//    private static final String URL = "mongodb+srv://user:unimongo1@creditmanagementsystem-hmkps.gcp.mongodb.net/test?retryWrites=true&w=majority";
//    private static final int PORT = 27017;
//    private static final String DATABASE_NAME = "CreditManagementSystem";
//    private static PersistenceHandler instance;
//    private MongoDatabase database;
//
//    private PersistenceHandler() {
//        initializeDatabase();
//    }
//
//    public static PersistenceHandler getInstance() {
//        if (instance == null) {
//            instance = new PersistenceHandler();
//        }
//        return instance;
//    }
//
//    private void initializeDatabase() {
//        try {
//            //MongoClient client = MongoClients.create("mongodb://" + URL + ":" + PORT);
//            MongoClient client = MongoClients.create(URL);
//            database = client.getDatabase(DATABASE_NAME);
//        } finally {
//            if (database == null) System.exit(-1);
//        }
//    }
//
//    @Override
//    public ArrayList<Admin> getAdmins() {
//        ArrayList<Admin> adminArrayList = new ArrayList();
//        FindIterable<Document> fi = database.getCollection("Admins").find();
//        MongoCursor<Document> cursor = fi.iterator();
//        try {
//            while(cursor.hasNext()) {
//                JSONObject obj = new JSONObject(cursor.next().toJson());
//                adminArrayList.add(new Admin(obj.getInt("_id"),obj.getString("username"), obj.getString("password")));
//            }
//        } finally {
//            cursor.close();
//            return adminArrayList;
//        }
//    }
//
//    @Override
//    public Admin getAdmin(int id) {
//        for (Admin admin : this.getAdmins()) {
//            if (admin.getId() == id) {
//                return admin;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Admin getAdmin(String name) {
//        for (Admin admin : this.getAdmins()) {
//            if (admin.getUsername().equals(name)) {
//                return admin;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean createAdmin(Admin admin) {
//        try {
//            MongoCollection admins = database.getCollection("Admins");
//            Document document = new Document("_id", admin.getId())
//                    .append("username", admin.getUsername())
//                    .append("password", admin.getPassword());
//            admins.insertOne(document);
//            return true;
//        } catch (MongoWriteException ex) {
//            return false;
//        }
//    }
//
//    @Override
//    public ArrayList<Producer> getProducers() {
//        ArrayList<Producer> producerArrayList = new ArrayList();
//        FindIterable<Document> fi = database.getCollection("Producers").find();
//        MongoCursor<Document> cursor = fi.iterator();
//        try {
//            while(cursor.hasNext()) {
//                JSONObject obj = new JSONObject(cursor.next().toJson());
//                producerArrayList.add(new Producer(obj.getInt("_id"),obj.getString("username"), obj.getString("password")));
//            }
//        } finally {
//            cursor.close();
//            return producerArrayList;
//        }
//    }
//
//    @Override
//    public Producer getProducer(int id) {
//        for (Producer producer : this.getProducers()) {
//            if (producer.getId() == id) {
//                return producer;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Producer getProducer(String name) {
//        for (Producer producer : this.getProducers()) {
//            if (producer.getUsername().equals(name)) {
//                return producer;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean createProducer(Producer producer) {
//        try {
//            MongoCollection producers = database.getCollection("Producers");
//            Document document = new Document("_id", producer.getId())
//                    .append("username", producer.getUsername())
//                    .append("password", producer.getPassword());
//            producers.insertOne(document);
//            return true;
//        } catch (MongoWriteException ex) {
//            return false;
//        }
//    }
//
//    @Override
//    public ArrayList<Production> getProductions() {
//        ArrayList<Production> productionArrayList = new ArrayList();
//        FindIterable<Document> fi = database.getCollection("Productions").find();
//        MongoCursor<Document> cursor = fi.iterator();
//        try {
//            while(cursor.hasNext()) {
//                JSONObject obj = new JSONObject(cursor.next().toJson());
//                productionArrayList.add(new Production(obj.getInt("_id"),obj.getString("name"), obj.getInt("producer_ID")));
//            }
//        } finally {
//            cursor.close();
//            return productionArrayList;
//        }
//    }
//
//    @Override
//    public Production getProduction(int id) {
//        for (Production production : this.getProductions()) {
//            if (production.getId() == id) {
//                return production;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean createProduction(Production production) {
//        try {
//            MongoCollection productions = database.getCollection("Productions");
//            Document document = new Document("_id", production.getId())
//                    .append("name", production.getName())
//                    .append("producer_ID", production.getProducerID());
//            productions.insertOne(document);
//            return true;
//        } catch (MongoWriteException ex) {
//            return false;
//        }
//    }
//
//    @Override
//    public ArrayList<Person> getPeople() {
//        ArrayList<Person> peopleArrayList = new ArrayList();
//        FindIterable<Document> fi = database.getCollection("People").find();
//        MongoCursor<Document> cursor = fi.iterator();
//        try {
//            while(cursor.hasNext()) {
//                JSONObject obj = new JSONObject(cursor.next().toJson());
//                peopleArrayList.add(new Person(obj.getInt("_id"),obj.getString("name"), obj.getString("contact_info")));
//            }
//        } finally {
//            cursor.close();
//            return peopleArrayList;
//        }
//    }
//
//    @Override
//    public Person getPerson(int id) {
//        for (Person person : this.getPeople()) {
//            if (person.getId() == id) {
//                return person;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean createPerson(Person person) {
//        try {
//            MongoCollection people = database.getCollection("People");
//            Document document = new Document("_id", person.getId())
//                    .append("name", person.getName())
//                    .append("contact_info", person.getContactInfo());
//            people.insertOne(document);
//            return true;
//        } catch (MongoWriteException ex) {
//            return false;
//        }
//    }
//
//    @Override
//    public ArrayList<Credit> getCredits() {
//        ArrayList<Credit> creditArrayList = new ArrayList();
//        FindIterable<Document> fi = database.getCollection("Credits").find();
//        MongoCursor<Document> cursor = fi.iterator();
//        try {
//            while(cursor.hasNext()) {
//                JSONObject obj = new JSONObject(cursor.next().toJson());
//                creditArrayList.add(new Credit(obj.getInt("_id"),obj.getInt("production_ID"), obj.getInt("person_ID"), obj.getString("role")));
//            }
//        } finally {
//            cursor.close();
//            return creditArrayList;
//        }
//    }
//
//    @Override
//    public Credit getCredit(int id) {
//        for (Credit credit : this.getCredits()) {
//            if (credit.getId() == id) {
//                return credit;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean createCredit(Credit credit) {
//        try {
//            MongoCollection credits = database.getCollection("Credits");
//            Document document = new Document("_id", credit.getId())
//                    .append("production_ID", credit.getProductionID())
//                    .append("person_ID", credit.getPersonID())
//                    .append("role", credit.getRole());
//            credits.insertOne(document);
//            return true;
//        } catch (MongoWriteException ex) {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean deleteCredit(int id) {
//        database.getCollection("Credits").findOneAndDelete(Filters.eq("_id", id));
//        return true;
//    }
//
//    public boolean editCredit(int id, Credit credit) {
//        try {
//            MongoCollection credits = database.getCollection("Credits");
//            Document document = new Document("_id", credit.getId())
//                    .append("production_ID", credit.getProductionID())
//                    .append("person_ID", credit.getPersonID())
//                    .append("role", credit.getRole());
//            if(credit.getId() != id && getCredit(id) != null) {
//                return false;
//            }
//            credits.findOneAndDelete(Filters.eq("_id", id));
//            credits.insertOne(document);
//            return true;
//        } catch (MongoWriteException ex) {
//            return false;
//        }
//
//    }
}
