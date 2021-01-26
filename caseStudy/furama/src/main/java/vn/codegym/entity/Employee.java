package vn.codegym.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Employee {
    @Id
    private String id;
    private String name;
    @Pattern(regexp = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$",message = "Date Format Exception (dd/mm/YYYY)!!!")
    private String birthday;
    @Pattern(regexp = "^\\d{9}|\\d{12}$",message = "Id card Format Exception (XXXXXXXXX) or (XXXXXXXXXXXX)!!!")
    private String idCard;
    @Min(value = 0,message = "Number Format Exception and salary >=0!!!")
    private String salary;
    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}",message = "Number Phone Format Exception (090|091)XXXXXXX !!!")
    private String phone;
    @Email
    @NotEmpty
    private String email;
    private String address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "education_degree_id",referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;

    @OneToMany(mappedBy = "employee")
    List<Contract> contractList;

    public Employee() {
    }

    public Employee(String id, String name, String birthday, String idCard, String salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
