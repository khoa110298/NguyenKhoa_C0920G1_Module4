package vn.codegym.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PhoneNumber {
    @NotNull
    @Pattern(regexp = "(^0[0-9]{9,10})$",message = "nhập lại")
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public PhoneNumber() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
