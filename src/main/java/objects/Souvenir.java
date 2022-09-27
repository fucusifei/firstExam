package objects;

import java.time.LocalDate;
public class Souvenir {
    private String name;
    private String manufacturerRequisites;
    private LocalDate createDate;
    private int cost;

    public Souvenir(String name, String manufacturerRequisites, LocalDate createDate, int cost) {
        this.name = name;
        this.manufacturerRequisites = manufacturerRequisites;
        this.createDate = createDate;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturerRequisites() {
        return manufacturerRequisites;
    }

    public void setManufacturerRequisites(String manufacturerRequisites) {
        this.manufacturerRequisites = manufacturerRequisites;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "name='" + name + '\'' +
                ", manufacturerRequisites='" + manufacturerRequisites + '\'' +
                ", createDate=" + createDate +
                ", cost=" + cost +
                '}';
    }
}
