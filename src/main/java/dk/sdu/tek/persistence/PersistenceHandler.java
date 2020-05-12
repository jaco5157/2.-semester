package dk.sdu.tek.persistence;

import com.mongodb.MongoWriteException;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import dk.sdu.tek.domain.*;
import org.bson.Document;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersistenceHandler implements IPersistenceHandler {
    private static final String URL = "mongodb+srv://user:unimongo1@creditmanagementsystem-hmkps.gcp.mongodb.net/test?retryWrites=true&w=majority";
//    private static final int PORT = 27017;
    private static final String DATABASE_NAME = "CreditManagementSystem";
    private static PersistenceHandler instance;
    private MongoDatabase database;

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
            //MongoClient client = MongoClients.create("mongodb://" + URL + ":" + PORT);
            MongoClient client = MongoClients.create(URL);
            database = client.getDatabase(DATABASE_NAME);
        } finally {
            if (database == null) System.exit(-1);
        }
    }

    @Override
    public ArrayList<Admin> getAdmins() {
        ArrayList<Admin> adminArrayList = new ArrayList();
        FindIterable<Document> fi = database.getCollection("Admins").find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
                JSONObject obj = new JSONObject(cursor.next().toJson());
                adminArrayList.add(new Admin(obj.getInt("_id"),obj.getString("username"), obj.getString("password")));
            }
        } finally {
            cursor.close();
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
            MongoCollection admins = database.getCollection("Admins");
            Document document = new Document("_id", admin.getId())
                    .append("username", admin.getUsername())
                    .append("password", admin.getPassword());
            admins.insertOne(document);
            return true;
        } catch (MongoWriteException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<Producer> getProducers() {
        ArrayList<Producer> producerArrayList = new ArrayList();
        FindIterable<Document> fi = database.getCollection("Producers").find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
                JSONObject obj = new JSONObject(cursor.next().toJson());
                producerArrayList.add(new Producer(obj.getInt("_id"),obj.getString("username"), obj.getString("password")));
            }
        } finally {
            cursor.close();
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
            MongoCollection producers = database.getCollection("Producers");
            Document document = new Document("_id", producer.getId())
                    .append("username", producer.getUsername())
                    .append("password", producer.getPassword());
            producers.insertOne(document);
            return true;
        } catch (MongoWriteException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<Production> getProductions() {
        ArrayList<Production> productionArrayList = new ArrayList();
        FindIterable<Document> fi = database.getCollection("Productions").find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
                JSONObject obj = new JSONObject(cursor.next().toJson());
                productionArrayList.add(new Production(obj.getInt("_id"),obj.getString("name"), obj.getInt("producer_ID")));
            }
        } finally {
            cursor.close();
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
            MongoCollection productions = database.getCollection("Productions");
            Document document = new Document("_id", production.getId())
                    .append("name", production.getName())
                    .append("producer_ID", production.getProducerID());
            productions.insertOne(document);
            return true;
        } catch (MongoWriteException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<Person> getPeople() {
        ArrayList<Person> peopleArrayList = new ArrayList();
        FindIterable<Document> fi = database.getCollection("People").find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
                JSONObject obj = new JSONObject(cursor.next().toJson());
                peopleArrayList.add(new Person(obj.getInt("_id"),obj.getString("name"), obj.getString("contact_info")));
            }
        } finally {
            cursor.close();
            return peopleArrayList;
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
            MongoCollection people = database.getCollection("People");
            Document document = new Document("_id", person.getId())
                    .append("name", person.getName())
                    .append("contact_info", person.getContactInfo());
            people.insertOne(document);
            return true;
        } catch (MongoWriteException ex) {
            return false;
        }
    }

    @Override
    public ArrayList<Credit> getCredits() {
        ArrayList<Credit> creditArrayList = new ArrayList();
        FindIterable<Document> fi = database.getCollection("Credits").find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
                JSONObject obj = new JSONObject(cursor.next().toJson());
                creditArrayList.add(new Credit(obj.getInt("_id"),obj.getInt("production_ID"), obj.getInt("person_ID"), obj.getString("role")));
            }
        } finally {
            cursor.close();
            return creditArrayList;
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
            MongoCollection credits = database.getCollection("Credits");
            Document document = new Document("_id", credit.getId())
                    .append("production_ID", credit.getProductionID())
                    .append("person_ID", credit.getPersonID())
                    .append("role", credit.getRole());
            credits.insertOne(document);
            return true;
        } catch (MongoWriteException ex) {
            return false;
        }
    }

    @Override
    public boolean deleteCredit(int id) {
        database.getCollection("Credits").findOneAndDelete(Filters.eq("_id", id));
        return true;
    }
}
