package com.example.project_oop;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Reader_rent_controller implements Initializable {

    public Label yourID;
    public Label message;
    public DatePicker returntime;
    @FXML
    private TableView<Book> booksTable;

    @FXML
    private TableColumn<Book, String> isbnColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> genreColumn;

    @FXML
    private TableColumn<Book, Boolean> availableColumn;

   

    @FXML
    private TableView<Book> rentedTable1;

    @FXML
    private TableColumn<Book, String> isbnColumn1;

    @FXML
    private TableColumn<Book, String> titleColumn1;

    @FXML
    private TableColumn<Book, String> authorColumn1;

    @FXML
    private TableColumn<Book, String> genreColumn1;

    @FXML
    private TableColumn<Book, Boolean> availableColumn1;

    @FXML
    private Button rentButton;

    @FXML
    private Button returnButton;

    @FXML
    private Label yourIdLabel;

    @FXML
    private Label idLabel;

    private static Reader reader;

    public Reader_rent_controller () {
         reader = ((Reader)HelloApplication.user);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if ( !(reader == null) ) {
            yourIdLabel.setText(reader.getFirstName());
            yourID.setText("Your ID : "+reader.getID());
            // Populate the "All Books" table
            isbnColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
            genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
            availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));

            // Fetch all books from a database or use sample data
            List<Book> allBooks = fetchAllBooks();

            // Add the books to the table
            allBooks.forEach(book -> booksTable.getItems().add(book));

            // Populate the "Rented Books" table
            isbnColumn1.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
            titleColumn1.setCellValueFactory(new PropertyValueFactory<>("title"));
            authorColumn1.setCellValueFactory(new PropertyValueFactory<>("author"));
            genreColumn1.setCellValueFactory(new PropertyValueFactory<>("genre"));
            availableColumn1.setCellValueFactory(new PropertyValueFactory<>("available"));

            // Fetch rented books for the reader user from a database or use sample data
            List<Book> rentedBooks = fetchRentedBooks();

            // Add the rented books to the table
            rentedBooks.forEach(book -> rentedTable1.getItems().add(book));
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("reader is not defined");
            alert.show();
        }
    }


    // method to fetch all books from library
    private List<Book> fetchAllBooks() {
        return HelloApplication.library.getBooks();
    }


    // method to fetch rented books for the reader user
    private List<Book> fetchRentedBooks() {
        return reader.getUser_rented_books();
    }


    @FXML
    private void handleRentButton(ActionEvent event) throws InterruptedException {
        // Get the selected book from the booksTable
        Book selectedBook = booksTable.getSelectionModel().getSelectedItem();
        LocalDate dt = LocalDate.now().plusDays(7);       // default return time after 7 days
        dt = returntime.getValue();
        if (selectedBook != null && selectedBook.isAvailable()) {
            // Rent the book and update the tables
            selectedBook.add_to_orderlist(reader);
            selectedBook.add_to_return_Dates_orderlists(dt);
            booksTable.getItems().remove(selectedBook);
            selectedBook.isAvailable();
        }else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Book is not available");
            alert.show();
        }
    }



    @FXML
    private void handleReturnButton() {
        // Get the selected book from the rentedTable1 TableView
        Book selectedBook = rentedTable1.getSelectionModel().getSelectedItem();
        // Check if a book is selected
        if (selectedBook != null) {
            // Remove the selected book from the user's rented books
            reader.getUser_rented_books().remove(selectedBook);
            // Update the rentedTable1 TableView with the updated list of rented books
            rentedTable1.getItems().setAll(reader.getUser_rented_books());
            booksTable.getItems().add(selectedBook);
            if ( (selectedBook.getReturn_Dates().get((reader.getUser_rented_books().indexOf(selectedBook)))).isBefore(LocalDate.now()) ) {
                System.out.println("Book returned successfully.");
            }else
            {
                reader.setBlocked(true);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("please select a Book to return ");
            alert.show();
        }
    }



}
