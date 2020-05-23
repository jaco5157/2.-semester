package dk.sdu.tek.domain;

import dk.sdu.tek.persistence.PersistenceHandler;

import java.sql.*;

public class main {

    public static void main(String[] args) {
//        new Admin(1, "jacob", "123").write();
//        PersistenceHandler.getInstance().createProducer(new Producer(1,"lort", "lort"));
//        PersistenceHandler.getInstance().createProduction(new Production(10,"Badehotellet",1));
//        PersistenceHandler.getInstance().createPerson(new Person(2,"Emil","nej"));
//        PersistenceHandler.getInstance().createCredit(new Credit(55, 1,1,"Superman"));

        System.out.println(PersistenceHandler.getInstance().getAdmins());
    }
}
