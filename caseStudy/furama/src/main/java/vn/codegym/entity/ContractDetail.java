package vn.codegym.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    private Contract contract;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "attach_service_id",referencedColumnName = "id")
    private AttachService attachService;
    @Pattern(regexp = "^[1-9]+\\d*$",message = "Number Format Exception and quantity is Integer")
    private String quantity;

    public ContractDetail() {
    }
    public ContractDetail(String quantity) {
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
