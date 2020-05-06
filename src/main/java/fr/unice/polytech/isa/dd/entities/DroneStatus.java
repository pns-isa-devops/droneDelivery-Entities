package fr.unice.polytech.isa.dd.entities;
//import org.jetbrains.annotations.NotNull;

//import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Embeddable
public class DroneStatus implements Serializable {

    @NotNull
    @Enumerated(EnumType.STRING)
    private DRONE_STATES libelleStatusDrone;

    @NotNull
    private String timeStartState;

    //    @NotNull
    private String timeEndState;

    public DroneStatus() {

    }
    public DroneStatus(DRONE_STATES state, String  hourBeginning) {
        libelleStatusDrone=  state;
        timeStartState = hourBeginning;
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
}
