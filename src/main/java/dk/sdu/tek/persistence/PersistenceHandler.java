package dk.sdu.tek.persistence;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dk.sdu.tek.domain.*;
import org.bson.Document;

import java.util.ArrayList;

public class PersistenceHandler implements IPersistenceHandler {
    private static final String URL = "localhost";
    private static final int PORT = 27017;
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
            MongoClient client = MongoClients.create("mongodb://" + URL + ":" + PORT);
            database = client.getDatabase(DATABASE_NAME);
        } finally {
            if (database == null) System.exit(-1);
        }
    }

    @Override
    public ArrayList<Admin> getAdmins() {
//        MongoCollection adminCollection = database.getCollection("Admins");
//        return adminCollection.find().into(new ArrayList());
        return null;
    }

    @Override
    public Admin getAdmin(int id) {
//        MongoCollection adminCollection = database.getCollection("Admins");
//        return adminCollection.find(Filters.eq("_id", id)).first();
        return null;
    }

    @Override
    public boolean createAdmin(Admin admin) {
        MongoCollection admins = database.getCollection("Admins");
        Document document = new Document("_id", admin.getId())
                .append("username", admin.getUsername())
                .append("password", admin.getPassword());
        admins.insertOne(document);
        return true;
    }

    @Override
    public ArrayList<Producer> getProducers() {
        return null;
    }

    @Override
    public Producer getProducer(int id) {
        return null;
    }

    @Override
    public boolean createProducer(Producer producer) {
        MongoCollection producers = database.getCollection("Producers");
        Document document = new Document("_id", producer.getId())
                .append("username", producer.getUsername())
                .append("password", producer.getPassword());
        producers.insertOne(document);
        return true;
    }

    @Override
    public ArrayList<Production> getProductions() {
        return null;
    }

    @Override
    public Production getProduction(int id) {
        return null;
    }

    @Override
    public boolean createProduction(Production production) {
        MongoCollection productions = database.getCollection("Productions");
        Document document = new Document("_id", production.getId())
                .append("name", production.getProductionName())
                .append("producer_ID", production.getProducerID());
        productions.insertOne(document);
        return true;
    }

    @Override
    public ArrayList<Person> getPeople() {
        return null;
    }

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public boolean createPerson(Person person) {
        MongoCollection people = database.getCollection("People");
        Document document = new Document("_id", person.getId())
                .append("name", person.getName())
                .append("contact_info", person.getContactInfo());
        people.insertOne(document);
        return true;
    }

    @Override
    public ArrayList<Credit> getCredits() {
        return null;
    }

    @Override
    public Credit getCredit(int id) {
        return null;
    }

    @Override
    public boolean createCredit(Credit credit) {
        MongoCollection credits = database.getCollection("Credits");
        Document document = new Document("_id", credit.getId())
                .append("production_ID", credit.getProductionID())
                .append("person_ID", credit.getPersonID())
                .append("role", credit.getRole());
        credits.insertOne(document);
        return true;
    }

    @Override
    public boolean deleteCredit(int id) {
        return false;
    }
}
