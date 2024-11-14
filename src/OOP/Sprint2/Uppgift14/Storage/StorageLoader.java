package OOP.Sprint2.Uppgift14.Storage;

import OOP.Sprint2.Uppgift14.PersonsCreation.BankCustomer;
import OOP.Sprint2.Uppgift14.PersonsCreation.BankStaff;

import java.io.*;
import java.util.ArrayList;

import java.util.List;

public class StorageLoader {
    private final List<BankStaff> bankStaffList;

    private final List<BankCustomer> bankCustomerList;


    private final static StorageLoader STORAGE_LOADER_INSTANCE = new StorageLoader();

    private StorageLoader() {
        StaffRoster.getInstance();
        CustomerRoster.getInstance();

        bankStaffList = new ArrayList<>();
        bankCustomerList = new ArrayList<>();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/OOP/Sprint2/Uppgift14/Storage/bankstaff.ser"))) {
            while (objectInputStream.readObject() instanceof BankStaff staffObjectToLoad) {
                this.bankStaffList.add(staffObjectToLoad);
            }
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {

            System.out.println("Hit end of File bankstaff.ser");
        } catch (IOException e) {

            e.printStackTrace();


        }


        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/OOP/Sprint2/Uppgift14/Storage/bankcustomers.ser"))) {
            while (objectInputStream.readObject() instanceof BankCustomer customerObjectToLoad) {
                this.bankCustomerList.add(customerObjectToLoad);
            }
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Hit end of File bankcustomers.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static StorageLoader getInstance() {
        return STORAGE_LOADER_INSTANCE;
    }



    public List<BankStaff> getBankStaffList() {
        return bankStaffList;
    }



    public List<BankCustomer> getBankCustomerList() {
        return bankCustomerList;
    }


}
