package dk.sdu.tek.persistance;

import dk.sdu.tek.domain.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ObjectReader {

    public enum Type {
        PRODUCTION,
        PERSON,
        PRODUCER,
        ADMIN,
        CREDIT
    }

    public static ArrayList<Object> readObject(Type type) throws UnsupportedOperationException{
        HashMap<Type,String> pathMap = new HashMap<>(){};
        pathMap.put(Type.PRODUCTION, "src/main/java/dk/sdu/tek/domain/productions.txt");
        pathMap.put(Type.PERSON, "src/main/java/dk/sdu/tek/domain/people.txt");
        pathMap.put(Type.PRODUCER, "src/main/java/dk/sdu/tek/domain/producers.txt");
        pathMap.put(Type.ADMIN, "src/main/java/dk/sdu/tek/domain/admins.txt");
        pathMap.put(Type.CREDIT, "src/main/java/dk/sdu/tek/domain/credits.txt");
        ArrayList<Object> objects = new ArrayList<>();

        try (Scanner objectScanner = new Scanner(new File(pathMap.get(type)))) {
            objectScanner.useDelimiter("[,\n]");

            switch (type) {
                case PRODUCTION:
                    while (objectScanner.hasNext()) {
                        objects.add(new Production(objectScanner.next(), objectScanner.nextInt()));
                    }
                    break;
                case PERSON:
                    while (objectScanner.hasNext()) {
                        objects.add(new Person(objectScanner.next(), objectScanner.nextInt(), objectScanner.next()));
                    }
                    break;
                case PRODUCER:
                    while (objectScanner.hasNext()) {
                        objects.add(new Producer(objectScanner.next(), objectScanner.next()));
                    }
                    break;
                case ADMIN:
                    while (objectScanner.hasNext()) {
                        objects.add(new Admin(objectScanner.next(), objectScanner.next()));
                    }
                    break;
                case CREDIT:
                    while (objectScanner.hasNext()) {
                        objects.add(new Credit(objectScanner.nextInt(), objectScanner.nextInt(), objectScanner.next()));
                    }
                    break;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Person file not found");
        } finally {
            return objects;
        }
    }

//    public static ArrayList<Production> readProductions() {
//        String filepath = "src/main/java/dk/sdu/tek/domain/productions.txt";
//        ArrayList<Production> productions = new ArrayList<>();
//
//        try {
//            scan = new Scanner(new File(filepath));
//            scan.useDelimiter("[,\n]");
//
//            while(scan.hasNext()) {
//                productions.add(new Production(scan.next(), scan.nextInt()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Person file not found");
//        } finally {
//            scan.close();
//            return productions;
//        }
//    }
//
//    public static ArrayList<Person> readPeople() {
//        String filepath = "src/main/java/dk/sdu/tek/domain/people.txt";
//        ArrayList<Person> people = new ArrayList<>();
//
//        try {
//            scan = new Scanner(new File(filepath));
//            scan.useDelimiter("[,\n]");
//
//            while(scan.hasNext()) {
//                people.add(new Person(scan.next(), scan.nextInt(), scan.next()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Person file not found");
//        } finally {
//            scan.close();
//            return people;
//        }
//    }
//
//    public static ArrayList<Producer> readProducers() {
//        String filepath = "src/main/java/dk/sdu/tek/domain/producers.txt";
//        ArrayList<Producer> producers = new ArrayList<>();
//
//        try {
//            scan = new Scanner(new File(filepath));
//            scan.useDelimiter("[,\n]");
//
//            while(scan.hasNext()) {
//                producers.add(new Producer(scan.next(), scan.next()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Producers file not found");
//        } finally {
//            scan.close();
//            return producers;
//        }
//    }
//
//    public static ArrayList<Admin> readAdmins() {
//        String filepath = "src/main/java/dk/sdu/tek/domain/admins.txt";
//        ArrayList<Admin> admins = new ArrayList<>();
//
//        try {
//            scan = new Scanner(new File(filepath));
//            scan.useDelimiter("[,\n]");
//
//            while(scan.hasNext()) {
//                admins.add(new Admin(scan.next(), scan.next()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Admins file not found");
//        } finally {
//            scan.close();
//            return admins;
//        }
//    }
//
//    public static List<Credit> readCredits() {
//        String filepath = "src/main/java/dk/sdu/tek/domain/credits.txt";
//        ArrayList<Credit> credits = new ArrayList<>();
//
//        try {
//            scan = new Scanner(new File(filepath));
//            scan.useDelimiter("[,\n]");
//
//            while(scan.hasNext()) {
//                credits.add(new Credit(scan.nextInt(), scan.nextInt(), scan.next()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Credits file not found");
//        } finally {
//            scan.close();
//            return credits;
//        }
//    }
}
