package fr.unice.polytech.isa.dd.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @OneToMany(mappedBy = "customer")
    private Set<Delivery> customer_deliveries = new HashSet<>();

    public Customer() {
        // Necessary for JPA instantiation process
    }

    public Customer(String n,String a) {
        name = n;
        address = a;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Delivery> getCustomer_deliveries() {
        return customer_deliveries;
    }

    public void setCustomer_deliveries(Set<Delivery> customer_deliveries) {
        this.customer_deliveries = customer_deliveries;
    }
    public void add_a_customer_delivery(Delivery delivery){
        this.customer_deliveries.add(delivery);
    }


    /*** ecriture de la méthode hash à faire ****/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    /**
     * Améliorer cette fonction
     * @return
     */
    @Override
    public int hashCode(){
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }



}
