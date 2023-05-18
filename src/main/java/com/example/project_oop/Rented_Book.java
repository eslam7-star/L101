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




}


