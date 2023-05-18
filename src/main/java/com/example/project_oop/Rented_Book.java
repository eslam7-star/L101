package com.example.project_oop;

import java.time.LocalDate;

public class Rented_Book extends Book{

    String firstname;
    String lastname;
    int ID;
    String Email;

    public LocalDate returndate;


    public Rented_Book(String title, String author, int ISBN, String genre, Boolean available ,String firstname,String lastname ,String Email,int ID, LocalDate ld) {
        super(title, author, ISBN, genre, available);
        this.returndate = ld;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ID = ID;
        this.Email = Email;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public void setReturndate(LocalDate returndate) {
        this.returndate = returndate;
    }
}


