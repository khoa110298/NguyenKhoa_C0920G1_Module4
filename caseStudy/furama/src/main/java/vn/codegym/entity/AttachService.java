package vn.codegym.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Min(value = 0,message = "Number Format Exception and Cost >=0!!!")
    private String cost;
    @Pattern(regexp = "^[1-9]+\\d*$",message = "Number Format Exception and quantity is Integer")
    private String unit;
    private String status;

    @OneToMany(mappedBy = "attachService")
    List<ContractDetail> contractDetailList;
    public AttachService() {
    }

    public AttachService(String name, String cost, String unit, String status) {
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
