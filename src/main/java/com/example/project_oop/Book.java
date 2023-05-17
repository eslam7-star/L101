package com.example.project_oop;

import java.util.ArrayList;
import java.util.Date;

public class Book {


    private ArrayList<Reader> rentals;
    public static int count = 0;
    private String title;
    private String author;

    // number of copies
    private int ISBN;
    private String genre;

    private Boolean available;

    private Date return_date,rent_date;

    public Book(String title, String author, int ISBN, String genre , Boolean available) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.available = available;
    }


    public ArrayList<Reader> getRentals() {
        return rentals;
    }

    public void setRentals(ArrayList<Reader> rentals) {
        this.rentals = rentals;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Date getRent_date() {
        return rent_date;
    }

    public void setRent_date(Date rent_date) {
        this.rent_date = rent_date;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public static void increament(){
        count++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }






}

