package fr.unice.polytech.isa.dd.entities;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Drone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String droneId;
    @NotNull
    private double battery; //In percentage

    @NotNull
    private double flightHours;

    @OneToMany(mappedBy = "drone")
    private List<Delivery> deliveries;

    //    @NotNull
    //Cest status management qui doit être ici du coup je pense je ne suis pas sûr
    //private DroneStatus droneStatus = new DroneStatus(DRONE_STATES.AVAILABLE, new Date(), null);
    @ElementCollection
    private List<DroneStatus> listStatusDrone;

    public Drone(){

    }

    public Drone(String drone_id) {
        this.droneId = drone_id;
        this.battery =  12.0;
        this.flightHours = 0.0;
        this.listStatusDrone = new ArrayList<>();
        this.deliveries = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public double getBatteryLife() {
        return this.battery;
    }

    public double getFlightHours() {
        return this.flightHours;
    }

    public List<DroneStatus> getStatusDrone(){return this.listStatusDrone;}

    public void reduceBatteryLife(double batteryUsed) {
        this.battery -= batteryUsed;
        this.flightHours += batteryUsed;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public void addStatut(DroneStatus stat)
    {
        this.listStatusDrone.add(stat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Drone))
            return false;
        Drone that = (Drone) o;
        return Objects.equals(id, that.id);
    }

    public String getDroneId() {
        return droneId;
    }

    public void setDroneId(String droneId) {
        this.droneId = droneId;
    }
}
