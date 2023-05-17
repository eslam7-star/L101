package com.example.project_oop;

import java.util.ArrayList;

public abstract class User {

    public static int nums = 0;
    private final int ID;
    private String Password;
    private String FirstName;
    private String LastName;
    private String Address;
    private String phone;
    private String Email;

    private String Type;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public User(String Password, String FirstName, String LastName, String Address, String CellPhone, String Email) {
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.phone = CellPhone;
        this.Email = Email;
        nums++;
        this.ID = nums;

    }


    public int getID() {
        return ID;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String CellPhone) {
        this.phone = CellPhone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public abstract void rent();

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Password='" + Password + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Address='" + Address + '\'' +
                ", CellPhone='" + phone + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }





}
