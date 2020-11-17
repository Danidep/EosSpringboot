package it.eos.springuser.model;

public class AnimalModel {

    private long id;

    private String type;

    private String family;

    private String genus;

    private String species;

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AnimalModel)) return false;
        if (!super.equals(object)) return false;
        AnimalModel that = (AnimalModel) object;
        return id == that.id &&
                type.equals(that.type) &&
                family.equals(that.family) &&
                genus.equals(that.genus) &&
                species.equals(that.species);
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
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}