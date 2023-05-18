package com.example.project_oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class librarian_rent_controller implements Initializable {


    @FXML
    private Button removebtn;
    @FXML
    private TableColumn<User,Integer> ID;
    @FXML
    private Button rentbtn;
    @FXML
    private Button blockbtn;
    @FXML
    private TableView<User> rentalstable;
    @FXML
    private TableColumn<User,String> firstname;
    @FXML
    private TableColumn<User,String> lastname;
    @FXML
    private TableColumn<User,String> Address;
    @FXML
    private TableColumn<User,String> phone;
    @FXML
    private TableColumn<User,String> Email;
    @FXML
    private TableView<Book> rentedtable;
    @FXML
    private TableColumn<Book,Integer> isbnColumn;
    @FXML
    private TableColumn<Book,String> titleColumn;
    @FXML
    private TableColumn<Book,String> authorColumn;
    @FXML
    private TableColumn<Book,String> genreColumn;
    @FXML
    private TableColumn<Book,Boolean> availableColumn;
    @FXML
    private TableColumn<Book, Date> rent_date;
    @FXML
    private TableColumn<Book, Date> return_date;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public librarian_rent_controller(User user) {
        this.user = user;
    }

    public librarian_rent_controller() {
        // Default constructor
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up event handler for when a book is selected in the rentedtable
        rentedtable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Fetch the rental users for the selected book
                Book selectedBook = rentedtable.getSelectionModel().getSelectedItem();
                if (selectedBook != null) {
                    // Get the users who rented the selected book
                    List<Reader> rentalUsers = ((Librarian)user).getRentals(selectedBook);
                    // Clear the existing data in the userstable
                    rentalstable.getItems().clear();
                    // Add the rental users to the userstable
                    rentalstable.getItems().addAll(rentalUsers);
                }
            }
        });
    }




/*
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
*/


}
