package fr.unice.polytech.isa.dd.entities;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@Entity
public class Drone implements Serializable {

  //  @Id
  // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @NotNull
    private int battery; //In percentage

//    @NotNull
    private int flightHours;

//    @NotNull
    private DroneStatus droneStatus = new DroneStatus(DRONE_STATES.AVAILABLE, new Date(), null);

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

    public DroneStatus getDroneStatus() {
        return droneStatus;
    }


    public void setBatteryLife(int percentageToReduce) {
        battery -= percentageToReduce;
    }

    public void setFlightHours(int nbHours) {
        flightHours += nbHours;
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

}
