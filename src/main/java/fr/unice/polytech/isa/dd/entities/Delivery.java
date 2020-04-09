package fr.unice.polytech.isa.dd.entities;
import org.joda.time.DateTime;
import utils.MyDate;

//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Random;
//import java.util.Date;

@Entity
public class Delivery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Customer customer;

    @OneToOne
    private Package packageDelivered;

    @ManyToOne
    private Bill bill;

    @ManyToOne
    private Drone drone;

    //@NotNull
    private String deliveryDate;
    private int deliveryBeginTimeInSeconds;
    private int deliveryEndTimeInSeconds;

    //@NotNull
    //private String beginTime;

    //@NotNull
    //private String endTime;

    private int customerMark;

    private double price;

    private boolean status;


    public Delivery() {
        // Necessary for JPA instantiation process
    }

    public Delivery(Customer c, Package p, String deliveryDateString, int begintimeinseconds) throws Exception {
        //id = new Random().nextInt();
        customer = c;
        packageDelivered = p;
        deliveryDate = deliveryDateString;
        deliveryBeginTimeInSeconds = begintimeinseconds;
        deliveryEndTimeInSeconds = begintimeinseconds + 2700;
        //beginTime = b;
        status = false;
        /**** Calcul du prix basique pour le moment basé sur le poids (10 Euros / grammes) ****/
        price = p.getWeight() * 10;
    }


    /*public void setEndTime(String e) {
        endTime = e;
        status = true;
    }*/

    public int getDeliveryBeginTimeInSeconds() {
        return deliveryBeginTimeInSeconds;
    }

    public int getDeliveryEndTimeInSeconds() {
        return deliveryEndTimeInSeconds;
    }

    public void setDeliveryBeginTimeInSeconds(int deliveryBeginTimeInSeconds) {
        this.deliveryBeginTimeInSeconds = deliveryBeginTimeInSeconds;
    }

    public void setDeliveryEndTimeInSeconds(int deliveryEndTimeInSeconds) {
        this.deliveryEndTimeInSeconds = deliveryEndTimeInSeconds;
    }

    public void setCustomerMark(int m) {
        customerMark = m;
    }

    public void setStatus(boolean s) {
        status = s;
    }

    public boolean getStatus(){
        return this.status;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Package getPackageDelivered() {
        return packageDelivered;
    }

    /*/public String getBeginTime() {
        return beginTime;
    }*/

    /*public String getEndTime() {
        return endTime;
    }*/

    public int getCustomerMark() {
        return customerMark;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPackageDelivered(Package packageDelivered) {
        this.packageDelivered = packageDelivered;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    /*public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }*/

    public void setPrice(double price) {
        this.price = price;
    }

    /*** ecriture de la méthode equals et hash à faire ****/

}
