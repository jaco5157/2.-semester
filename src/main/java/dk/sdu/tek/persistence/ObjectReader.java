package dk.sdu.tek.persistence;

import dk.sdu.tek.domain.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ObjectReader {

    private static String directory = "src/main/java/dk/sdu/tek/persistence/";

    public enum Type {
        PRODUCTION,
        PERSON,
        PRODUCER,
        ADMIN,
        CREDIT
    }

    public static ArrayList readObject(Type type) {
        HashMap<Type,String> file = new HashMap<>(){};
        file.put(Type.PRODUCTION, "productions.txt");
        file.put(Type.PERSON, "people.txt");
        file.put(Type.PRODUCER, "producers.txt");
        file.put(Type.ADMIN, "admins.txt");
        file.put(Type.CREDIT, "credits.txt");
        ArrayList objects = new ArrayList<>();

        try (Scanner objectScanner = new Scanner(new File(directory+file.get(type)))) {
            objectScanner.useDelimiter("[\n]");
            while (objectScanner.hasNext()) {
                String[] line = objectScanner.next().split(",");
                switch (type) {
                    case PRODUCTION:
                        objects.add(new Production(line[0], parseInt(line[1]), parseInt(line[2])));
                        break;
                    case PERSON:
                        objects.add(new Person(line[0], parseInt(line[1]), line[2]));
                        break;
                    case PRODUCER:
                        objects.add(new Producer(line[0], line[1], parseInt(line[2])));
                        break;
                    case ADMIN:
                        objects.add(new Admin(line[0], line[1]));
                        break;
                    case CREDIT:
                        objects.add(new Credit(parseInt(line[0]), parseInt(line[1]), line[2]));
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(file.get(type) + " not found");
        } finally {
            return objects;
        }
    }


//    switch (type) {
//        case PRODUCTION:
//            while (objectScanner.hasNext()) {
//                objects.add(new Production(objectScanner.next(), objectScanner.nextInt(), objectScanner.nextInt()));
//            }
//            break;
//        case PERSON:
//            while (objectScanner.hasNext()) {
//                objects.add(new Person(objectScanner.next(), objectScanner.nextInt(), objectScanner.next()));
//            }
//            break;
//        case PRODUCER:
//            while (objectScanner.hasNext()) {
//                objects.add(new Producer(objectScanner.next(), objectScanner.next(), objectScanner.nextInt()));
//            }
//            break;
//        case ADMIN:
//            while (objectScanner.hasNext()) {
//                objects.add(new Admin(objectScanner.next(), objectScanner.next()));
//            }
//            break;
//        case CREDIT:
//            while (objectScanner.hasNext()) {
//                objects.add(new Credit(objectScanner.nextInt(), objectScanner.nextInt(), objectScanner.next()));
//            }
//            break;
//    }

//    public static ArrayList<Production> readProductions() {
//        String filepath = directory += "productions.txt";
//        ArrayList<Production> productions = new ArrayList<>();
//
//        try {
//            objectScanner = new Scanner(new File(filepath));
//            objectScanner.useDelimiter("[,\n]");
//
//            while(objectScanner.hasNext()) {
//                productions.add(new Production(objectScanner.next(), objectScanner.nextInt(), objectScanner.nextInt()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Person file not found");
//        } finally {
//            objectScanner.close();
//            return productions;
//        }
//    }
//
//    public static ArrayList<Person> readPeople() {
//        String filepath = directory += "people.txt";
//        ArrayList<Person> people = new ArrayList<>();
//
//        try {
//            objectScanner = new Scanner(new File(filepath));
//            objectScanner.useDelimiter("[,\n]");
//
//            while(objectScanner.hasNext()) {
//                people.add(new Person(objectScanner.next(), objectScanner.nextInt(), objectScanner.next()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Person file not found");
//        } finally {
//            objectScanner.close();
//            return people;
//        }
//    }
//
//    public static ArrayList readProducers() {
//        String filepath = directory += "producers.txt";
//        ArrayList<Producer> producers = new ArrayList<>();
//
//        try {
//            objectScanner = new Scanner(new File(filepath));
//            objectScanner.useDelimiter("[,\n]");
//
//            while(objectScanner.hasNext()) {
//                producers.add(new Producer(objectScanner.next(), objectScanner.next(), objectScanner.nextInt()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Producers file not found");
//        } finally {
//            objectScanner.close();
//            return producers;
//        }
//    }
//
//    public static ArrayList readAdmins() {
//        String filepath = directory += "admins.txt";
//        ArrayList<Admin> admins = new ArrayList<>();
//
//        try {
//            objectScanner = new Scanner(new File(filepath));
//            objectScanner.useDelimiter("[,\n]");
//
//            while(objectScanner.hasNext()) {
//                admins.add(new Admin(objectScanner.next(), objectScanner.next()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Admins file not found");
//        } finally {
//            objectScanner.close();
//            return admins;
//        }
//    }
//
//    public static ArrayList<Credit> readCredits() {
//        String filepath = directory += "credits.txt";
//        ArrayList<Credit> credits = new ArrayList<>();
//
//        try {
//            objectScanner = new Scanner(new File(filepath));
//            objectScanner.useDelimiter("[,\n]");
//
//            while(objectScanner.hasNext()) {
//                credits.add(new Credit(objectScanner.nextInt(), objectScanner.nextInt(), objectScanner.next()));
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println("Credits file not found");
//        } finally {
//            objectScanner.close();
//            return credits;
//        }
//    }
}
