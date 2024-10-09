package OOP.Sprint2.Uppgift14.Storage;

import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StaffRoster {

    private final List<BankStaff> staff;

    private final static StaffRoster STAFF_ROSTER = new StaffRoster();


    private StaffRoster() {
        staff = new ArrayList<>();
        staff.add(new BankStaff("Lion Anderson", 39000));
        staff.add(new BankStaff("Liana Gonzales", 22000));
        staff.add(new BankStaff("Lucille Ruiz", 43000));
        staff.add(new BankStaff("Melody Adams", 55000));
        staff.add(new BankStaff("Jaxtyn Roman", 21000));
        staff.add(new BankStaff("Kyree Gomez", 37400));
        staff.add(new BankStaff("Josie Strickland", 34200));
        staff.add(new BankStaff("Chloe Kane", 33200));
        staff.add(new BankStaff("Eva Mchand", 33210));
        staff.add(new BankStaff("Orion Wealth", 31120));
        staff.add(new BankStaff("Bentley John", 33230));
        staff.add(new BankStaff("Rey Beasley", 31110));
        staff.add(new BankStaff("CHandler Yoder", 45550));
        staff.add(new BankStaff("Luke Dalton", 65210));
        staff.add(new BankStaff("Johan Crane", 23210));
        staff.add(new BankStaff("Andrea Norton", 54220));
        staff.add(new BankStaff("Oaklyn Joder", 19220));
        staff.add(new BankStaff("Kyla Mortades", 75110));

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/OOP/Sprint2/Uppgift14/Storage/bankstaff.ser"))) {
          for (BankStaff staff : staff) {
              outputStream.writeObject(staff);
          }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static StaffRoster getInstance() {
        return STAFF_ROSTER;
    }

    protected List<BankStaff> getCustomers() {
        return staff;
    }
}
