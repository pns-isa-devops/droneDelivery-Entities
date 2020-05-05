package fr.unice.polytech.isa.dd.entities;
//import org.jetbrains.annotations.NotNull;

//import javax.persistence.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Embeddable
public class DroneStatus implements Serializable {

    //    @NotNull
    private DRONE_STATES libelleStatusDrone;

    //    @NotNull
    private String timeStartState;

    //    @NotNull
    private String timeEndState;

    @ManyToOne
    private Drone drone;

    public DroneStatus() {

    }
    public DroneStatus(Drone drone, DRONE_STATES state, String  hourBeginning) {
        libelleStatusDrone=  state;
        timeStartState = hourBeginning;
        this.drone=drone;
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

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }
}
