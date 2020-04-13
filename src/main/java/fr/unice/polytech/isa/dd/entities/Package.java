package fr.unice.polytech.isa.dd.entities;
import org.joda.time.DateTime;
import utils.MyDate;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Package implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String secretNumber;

    @NotNull
    private double weight;

//    @NotNull
    private String deliveryDate;

    @ManyToOne
    private Provider provider;

    public Package() {
        // Necessary for JPA instantiation process
    }

    public Package(String secretN,Double w,String d, Provider pro) {
        secretNumber = secretN;
        weight = w;
        deliveryDate = d;
        provider = pro;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Provider getProvider() {
        return provider;
    }

    public int getProvider_id() {
        return provider.getId();
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getSecret_number() {
        return secretNumber;
    }

    public void setSecret_number(String secret_number) {
        this.secretNumber = secret_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /*** ecriture de la méthode hash à faire ****/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package that = (Package) o;
        return Objects.equals(secretNumber, that.secretNumber) && Double.compare(that.weight, weight) == 0;
    }

    @Override
    public int hashCode(){
        int result = getSecret_number().hashCode();
        result = 31 * result;
        return result;
    }

}
