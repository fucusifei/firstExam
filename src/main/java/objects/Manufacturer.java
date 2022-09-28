package objects;

public class Manufacturer {
    private String name;
    private String requisites;
    private String country;
    private long countOfSouvenirTypes;




    public Manufacturer(String name, String requisites, String country, long countOfSouvenirTypes) {
        this.name = name;
        this.requisites = requisites;
        this.country = country;
        this.countOfSouvenirTypes = countOfSouvenirTypes;
    }
    public long getCountOfSouvenirTypes() {
        return countOfSouvenirTypes;
    }

    public void setCountOfSouvenirTypes(long countOfSouvenirTypes) {
        this.countOfSouvenirTypes = countOfSouvenirTypes;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", requisites='" + requisites + '\'' +
                ", country='" + country + '\'' +
                ", countOfSouvenirTypes=" + countOfSouvenirTypes +
                '}';
    }
}
