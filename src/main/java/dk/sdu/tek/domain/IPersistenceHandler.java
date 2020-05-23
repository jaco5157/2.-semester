package dk.sdu.tek.domain;

import java.util.ArrayList;

public interface IPersistenceHandler {

    public ArrayList<Admin> getAdmins();

    public Admin getAdmin(int id);

    public Admin getAdmin(String name);

    public boolean createAdmin(Admin admin);

    public ArrayList<Producer> getProducers();

    public Producer getProducer(int id);

    public Producer getProducer(String name);

    public boolean createProducer(Producer producer);

    public ArrayList<Production> getProductions();

    public Production getProduction(int id);

    public boolean createProduction(Production production);

    public ArrayList<Person> getPeople();

    public Person getPerson(int id);

    public boolean createPerson(Person person);

    public ArrayList<Credit> getCredits();

    public Credit getCredit(int id);

    public boolean createCredit(Credit credit);

    public boolean deleteCredit(int id);

    public boolean editCredit(Credit credit);
}
