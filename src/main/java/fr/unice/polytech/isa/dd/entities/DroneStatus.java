package fr.unice.polytech.isa.dd.entities;
//import org.jetbrains.annotations.NotNull;

//import javax.persistence.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class DroneStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //    @NotNull
    private DRONE_STATES libelleStatusDrone;

    //    @NotNull
    private Date timeStartState;

    //    @NotNull
    private Date timeEndState;

    @ManyToOne
    private Drone drone;

    public DroneStatus(Drone drone, DRONE_STATES state, Date hourBeginning, Date hourEnd) {
        libelleStatusDrone=  state;
        timeStartState = hourBeginning;
        timeEndState = hourEnd;
        drone=drone;
    }
    public DroneStatus(Drone drone, DRONE_STATES state, Date hourBeginning) {
        libelleStatusDrone=  state;
        timeStartState = hourBeginning;
        drone=drone;
    }

    public int getId() {
        return this.id;
    }

    public DRONE_STATES getLibelleStatusDrone () {
        return libelleStatusDrone;
    }

    public Date getTimeStartState() {
        return timeStartState;
    }

    public Date getTimeEndState() {
        return timeEndState;
    }


    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }
}
