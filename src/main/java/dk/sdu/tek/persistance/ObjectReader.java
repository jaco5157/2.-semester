package dk.sdu.tek.persistance;

import dk.sdu.tek.domain.*;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectReader {

    private Scanner scan;

    public ObjectReader () {

    }

    public ArrayList<Production> readProductions() throws UnsupportedOperationException{
        String filepath = "src/main/java/dk/sdu/tek/domain/productions.txt";
        ArrayList<Production> productions = new ArrayList<>();

        try {
            scan = new Scanner(new File(filepath));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext()) {
                productions.add(new Production(scan.next(), scan.nextInt()));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Person file not found");
        } finally {
            scan.close();
            return productions;
        }
    }

    public ArrayList<Person> readPeople() throws UnsupportedOperationException{
        String filepath = "src/main/java/dk/sdu/tek/domain/people.txt";
        ArrayList<Person> people = new ArrayList<>();

        try {
            scan = new Scanner(new File(filepath));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext()) {
                people.add(new Person(scan.next(), scan.nextInt(), scan.next()));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Person file not found");
        } finally {
            scan.close();
            return people;
        }
    }

    public ArrayList<Producer> readProducers() throws UnsupportedOperationException{
        String filepath = "src/main/java/dk/sdu/tek/domain/producers.txt";
        ArrayList<Producer> producers = new ArrayList<>();

        try {
            scan = new Scanner(new File(filepath));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext()) {
                producers.add(new Producer(scan.next(), scan.next()));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Producers file not found");
        } finally {
            scan.close();
            return producers;
        }
    }

    public ArrayList<Admin> readAdmins() throws UnsupportedOperationException{
        String filepath = "src/main/java/dk/sdu/tek/domain/admins.txt";
        ArrayList<Admin> admins = new ArrayList<>();

        try {
            scan = new Scanner(new File(filepath));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext()) {
                admins.add(new Admin(scan.next(), scan.next()));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Admins file not found");
        } finally {
            scan.close();
            return admins;
        }
    }

    public List<Credit> readCredits() throws UnsupportedOperationException{
        String filepath = "src/main/java/dk/sdu/tek/domain/credits.txt";
        ArrayList<Credit> credits = new ArrayList<>();

        try {
            scan = new Scanner(new File(filepath));
            scan.useDelimiter("[,\n]");

            while(scan.hasNext()) {
                credits.add(new Credit(scan.nextInt(), scan.nextInt(), scan.next()));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Credits file not found");
        } finally {
            scan.close();
            return credits;
        }
    }
}
