package fr.unice.polytech.isa.dd.entities;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "provider")
    private Set<Package> packages = new HashSet<>();

    @OneToMany(mappedBy = "provider")
    private Set<Bill> provider_bills = new HashSet<>();


    public Provider() {
        // Necessary for JPA instantiation process
    }

    public Provider(String n) {
        name = n;
    }

    public void add(Package p) { this.packages.add(p); }

    public void add(Bill b) {this.provider_bills.add(b);}

    public Set<Package> getPackages() { return packages; }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackages(Set<Package> packages) {
        this.packages = packages;
    }

    public Set<Bill> getProvider_bills() {
        return provider_bills;
    }

    public void setProvider_bills(Set<Bill> provider_bills) {
        this.provider_bills = provider_bills;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider that = (Provider) o;
        return Objects.equals(name, that.name);
    }

    /**
     * Améliorer cette fonction
     * @return
     */
    @Override
    public int hashCode(){
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result;
        return result;
    }

}
