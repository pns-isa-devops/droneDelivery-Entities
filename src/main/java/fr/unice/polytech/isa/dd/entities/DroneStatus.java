package fr.unice.polytech.isa.dd.entities;
//import org.jetbrains.annotations.NotNull;

//import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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


    public DroneStatus(DRONE_STATES state, Date hourBeginning, Date hourEnd) {
        libelleStatusDrone=  state;
        timeStartState = hourBeginning;
        timeEndState = hourEnd;
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


}
