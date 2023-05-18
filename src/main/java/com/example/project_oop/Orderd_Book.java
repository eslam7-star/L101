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





}


