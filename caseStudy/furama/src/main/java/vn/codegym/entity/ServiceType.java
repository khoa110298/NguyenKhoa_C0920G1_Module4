package vn.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "serviceType")
    List<ServiceEntity> serviceList;

    public ServiceType() {
    }

    public ServiceType(String name) {
        this.name = name;
    }

    public Integer getId() {
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

    public List<ServiceEntity> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceEntity> serviceList) {
        this.serviceList = serviceList;
    }
}
