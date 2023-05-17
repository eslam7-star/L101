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


    public ArrayList<User> getAdded_uers() {
        return added_uers;
    }

    public void setAdded_uers(ArrayList<User> added_uers) {
        this.added_uers = added_uers;
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
        User selectedUser =  userstable.getSelectionModel().getSelectedItem();
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        rent(selectedUser, selectedBook);
    }

}

class librarian_rent_controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }




    void rent(User user, Book book) {
        if (user == null || book == null) {

            return;
        }
        if (!book.isAvailable()) {
            return;
        }
        // Perform the rental process using the provided user and book
        boolean rentalSuccess = HelloApplication.library.rentBook(user, book);
        if (rentalSuccess) {
            // Update the table views to reflect the changes
            userstable.refresh();
            bookTable.refresh();
        } else {
        }
    }











}
