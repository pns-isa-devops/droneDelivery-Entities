package fr.unice.polytech.isa.dd.entities;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Drone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //    @NotNull
    private int battery; //In percentage

    //    @NotNull
    private int flightHours;

    @OneToMany(mappedBy = "drone")
    private List<Delivery> deliveries;

    //    @NotNull
    //Cest status management qui doit être ici du coup je pense je ne suis pas sûr
    //private DroneStatus droneStatus = new DroneStatus(DRONE_STATES.AVAILABLE, new Date(), null);
    @OneToMany(mappedBy = "drone")
    private List<DroneStatus> statusDrone;

    public Drone(){

    }

    public Drone(int n_battery, int  n_flightHours) {
        battery=  n_battery;
        flightHours = n_flightHours;
    }

    public int getId() {
        return this.id;
    }

    public int getBatteryLife() {
        return battery;
    }

    public int getFlightHours() {
        return flightHours;
    }

    /*public DroneStatus getDroneStatus() {
        return droneStatus;
    }*/


    public void setBatteryLife(int percentageToReduce) {
        battery -= percentageToReduce;
    }

    public void setFlightHours(int nbHours) {
        flightHours += nbHours;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

   /* public void setDroneStatus(DroneStatus droneStatus) {
        this.droneStatus = droneStatus;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Drone))
            return false;
        Drone that = (Drone) o;
        return Objects.equals(id, that.id);
    }

}
