package dk.sdu.tek.domain;

import dk.sdu.tek.persistance.ObjectReader;

import java.util.List;

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
        List<Admin> adminList = ObjectReader.readAdmins();
        System.out.println("Read from file using ObjectReader");
        System.out.println(adminList);
        System.out.println("Print single admin object");
        System.out.println(adminList.get(0));
        System.out.println(adminList.get(4));
    }
}
