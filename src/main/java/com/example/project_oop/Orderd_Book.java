package com.example.project_oop;

import java.time.LocalDate;

public class Orderd_Book extends Book{

    String firstname;
    String lastname;
    int ID;
    String Email;

    LocalDate return_date;


    public LocalDate returndate;
    public Orderd_Book(String title, String author, int ISBN, String genre, Boolean available , String firstname, String lastname ,int ID ,String Email , LocalDate LD) {
        super(title, author, ISBN, genre, available);
        this.returndate = LD;
        this.firstname = firstname;
        this.lastname = lastname;
        this.Email = Email;
        this.ID =ID;
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

    public LocalDate getReturnDate() {
        return return_date;
    }


    public void setReturnDate(LocalDate returnDate) {
        this.returndate = returnDate;
    }




}


