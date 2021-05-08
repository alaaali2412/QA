package com.assessment.QA.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class TicketParams {
    @NotEmpty
    private String name;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;
    @NotEmpty
    private int terminalID;
    @NotEmpty
    @Length(max = 200)
    private String message;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(int terminalID) {
        this.terminalID = terminalID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
