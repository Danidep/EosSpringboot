package it.eos.springuser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "FAMILY")
    private String family;

    @Column(name = "GENUS")
    private String genus;

    @Column(name = "SPECIES")
    private String species;

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AnimalEntity)) return false;
        if (!super.equals(object)) return false;
        AnimalEntity that = (AnimalEntity) object;
        return id == that.getId() &&
                type.equals(that.getType()) &&
                family.equals(that.getFamily()) &&
                genus.equals(that.getGenus()) &&
                species.equals(that.getSpecies());
    }

    public int hashCode() {
        return super.hashCode();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "AnimalModel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", family='" + family + '\'' +
                ", genus='" + genus + '\'' +
                ", species='" + species + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}