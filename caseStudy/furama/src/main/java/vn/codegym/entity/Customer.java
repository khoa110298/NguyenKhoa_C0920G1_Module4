package vn.codegym.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "customer")
public class Customer {
    @Id
    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Id Customer Format Exception (KH-XXXX) !!!")
    private String id;
    private String name;
    @Column(name = "birthday",columnDefinition = "date")
    @Pattern(regexp = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$",message = "Date Format Exception (dd/mm/YYYY)!!!")
    private String birthday;
    private String gender;
    @Pattern(regexp = "^\\d{9}|\\d{12}$",message = "Id card Format Exception (XXXXXXXXX) or (XXXXXXXXXXXX)!!!")
    private String idCard;
    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}",message = "Number Phone Format Exception (090|091)XXXXXXX !!!")
    private String phone;
    @Email
    @NotEmpty
    private String email;
    private String address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_type_id",referencedColumnName = "id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    List<Contract> contractList;
    public Customer() {
    }

    public Customer(String id, String name, String birthday, String gender, String idCard, String phone, String email,String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
