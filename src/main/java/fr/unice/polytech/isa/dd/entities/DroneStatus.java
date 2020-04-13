package fr.unice.polytech.isa.dd.entities;
//import org.jetbrains.annotations.NotNull;

//import javax.persistence.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class DroneStatus implements Serializable {

    private int id;

    //    @NotNull
    private DRONE_STATES libelleStatusDrone;

    //    @NotNull
    private String timeStartState;

    //    @NotNull
    private String timeEndState;

    private Drone drone;

    public DroneStatus() {

    }
    public DroneStatus(Drone drone, DRONE_STATES state, String  hourBeginning) {
        libelleStatusDrone=  state;
        timeStartState = hourBeginning;
        drone=drone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public DRONE_STATES getLibelleStatusDrone () {
        return libelleStatusDrone;
    }

    public String getTimeStartState() {
        return timeStartState;
    }

    public String getTimeEndState() {
        return timeEndState;
    }

    @ManyToOne
    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }
}
