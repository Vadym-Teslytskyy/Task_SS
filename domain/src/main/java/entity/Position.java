package entity;

import java.math.BigDecimal;

public class Position {

    private Integer id;

    private String companyName;

    private String positionName;

    private BigDecimal salary;

    public Position() {
    }

    public Position(Integer id, String companyName, String positionName, BigDecimal salary) {
        this.id = id;
        this.companyName = companyName;
        this.positionName = positionName;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Position{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
