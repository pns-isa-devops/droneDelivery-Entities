package fr.unice.polytech.isa.dd.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Status_management implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Drone drone;

    @OneToOne
    private DroneStatus status;

    public Status_management(){}

    public Status_management(Drone drone, DroneStatus status){
        this.drone = drone;
        this.status=status;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }
    public DroneStatus getStatus() {
        return status;
    }

    public void setStatus(DroneStatus status) {
        this.status = status;
    }
}
