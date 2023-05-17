package com.example.project_oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class Librarian extends User {


    private ArrayList<User> rentals;
    private ArrayList<Book> added_books;
    private ArrayList<User> blocked_users;
    private ArrayList<Book> rented_books;


    public ArrayList<Reader> getRentals(Book book) {
        return book.getRentals();
    }

    public void setRentals(ArrayList<User> rentals) {
        this.rentals = rentals;
    }

    public ArrayList<Book> getAdded_books() {
        return added_books;
    }

    public void setAdded_books(ArrayList<Book> added_books) {
        this.added_books = added_books;
    }

    public ArrayList<User> getBlocked_users() {
        return blocked_users;
    }

    public void setBlocked_users(ArrayList<User> blocked_users) {
        this.blocked_users = blocked_users;
    }

    public ArrayList<Book> getRented_books() {
        return rented_books;
    }

    public void setRented_books(ArrayList<Book> rented_books) {
        this.rented_books = rented_books;
    }

    public Librarian(String Password, String FirstName, String LastName, String Address, String CellPhone, String Email) {
        super(Password, FirstName, LastName, Address, CellPhone, Email);
        setType("Librarian");
    }


    @FXML
    public void rent() {

    }



}



