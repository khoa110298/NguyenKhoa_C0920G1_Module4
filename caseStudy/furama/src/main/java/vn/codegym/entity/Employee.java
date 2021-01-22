package vn.codegym.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    private String id;
    private String name;
    private String birthday;
    private String idCard;
    private String salary;
    private String phone;
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
}
