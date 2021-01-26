package vn.codegym.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Contract {
    @Id
    private String id;
    @Pattern(regexp = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$",message = "Date Format Exception (dd/mm/YYYY)!!!")
    private String startDate;
    @Pattern(regexp = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$",message = "Date Format Exception (dd/mm/YYYY)!!!")
    private String endDate;
    @Min(value = 0,message = "Number Format Exception and deposit >=0!!!")
    private String deposit;
    @Min(value = 0,message = "Number Format Exception and totalMoney >=0!!!")
    private String totalMoney;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "service_id",referencedColumnName = "id")
    private ServiceEntity serviceEntity;

    @OneToMany(mappedBy = "contract")
    List<ContractDetail> contractDetailList;

    public Contract() {
    }

    public Contract(String id, String startDate, String endDate, String deposit, String totalMoney) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
