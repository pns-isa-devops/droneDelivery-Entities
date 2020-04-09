package fr.unice.polytech.isa.dd.entities;


import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Database {


    private List<Delivery> deliveryList;
    private List<Customer> customerList;
    private List<Provider> providerList;
    private List<Bill> billList;
//    private static boolean initialize = false;


    private Database() {
        customerList = new ArrayList<Customer>();
        deliveryList = new ArrayList<>();
        providerList = new ArrayList<>();
        billList = new ArrayList<>();
//        if(initialize){
//            System.out.println("okki");
//        this.initializeDatabase();
//        }
    }

    public void clearDatabase() {
        customerList.clear();
        deliveryList.clear();
        providerList.clear();
        billList.clear();
    }

    public void initializeDatabase() {
        /*Customer c = new Customer("Paul Marie", "adresse1");
        Customer c1 = new Customer("Paul Koffi", "adresse2");
        Customer c2 = new Customer("Messan Aurore", "adresse3");

        customerList.add(c);

        DateTime dt = new DateTime();

        Provider pro1 = new Provider(1, "AMAZON");
        Provider pro2 = new Provider(2, "LILLY");
        providerList.add(pro1);
        providerList.add(pro2);

        Package pk1 = new Package(1, 2.0, dt, pro1);
        Package pk2 = new Package(2, 7.0, dt, pro1);
        Package pk3 = new Package(3, 6.0, dt, pro1);

        /*Delivery d1 = new Delivery(c, pk1, dt, null);
        Delivery d2 = new Delivery(c1, pk2, dt, null);
        Delivery d3 = new Delivery(c2, pk3, dt, null);
        deliveryList.add(d1);
        deliveryList.add(d2);
        deliveryList.add(d3);*/

    }

    private static Database INSTANCE = new Database();

    public static Database getInstance() {
        return INSTANCE;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    public List<Bill> getBillList() {
        return billList;
    }
}