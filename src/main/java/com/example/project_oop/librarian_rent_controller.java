package com.example.project_oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;




public class librarian_rent_controller implements Initializable {

    public Label yourid;
    public Label yourlabel;
    @FXML
    private TableView<Book> allbooks;

    @FXML
    private TableView<Orderd_Book> waitingtable;

    @FXML
    private TableView<Rented_Book> rentaltable;

    @FXML
    private TableColumn<Book, String> isbnColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> genreColumn;

    @FXML
    private TableColumn<Book, String> availableColumn;

    @FXML
    private TableColumn<Orderd_Book, String> wID;

    @FXML
    private TableColumn<Orderd_Book, String> wfirstname;

    @FXML
    private TableColumn<Orderd_Book, String> wlastname;


    @FXML
    private TableColumn<Orderd_Book, String> wEmail;

    @FXML
    private TableColumn<Orderd_Book, LocalDate> wreturn_date;

    @FXML
    private TableColumn<Rented_Book, String> rID;

    @FXML
    private TableColumn<Rented_Book, String> rfirstname;

    @FXML
    private TableColumn<Rented_Book, String> rlastname;


    @FXML
    private TableColumn<Rented_Book, String> rEmail;

    @FXML
    private TableColumn<Rented_Book, LocalDate> rreturn_date;

    private static Librarian librarian;

    public Book selbook;

    public librarian_rent_controller() {
        librarian = (Librarian) HelloApplication.user;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        yourlabel.setText("Hi "+ librarian.getFirstName());
        yourid.setText( "Your ID : "+ librarian.getID());
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        // Fetch all books and populate the table
        allbooks.getItems().addAll(HelloApplication.library.getBooks());
        allbooks.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Fetch data for rentals table
                List<Rented_Book> rentals = fetchRentals(newSelection);
                rentaltable.setItems(FXCollections.observableArrayList(rentals));

                // Set up cell value factories for rentals table
                rID.setCellValueFactory(new PropertyValueFactory<>("ID"));
                rfirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                rlastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                rEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
                rreturn_date.setCellValueFactory(new PropertyValueFactory<>("returnDate"));

                // Fetch data for waitlist table
                List<Orderd_Book> waitlist = fetchWaitlist(newSelection);
                waitingtable.setItems(FXCollections.observableArrayList(waitlist));

                // Set up cell value factories for waitlist table
                wID.setCellValueFactory(new PropertyValueFactory<>("ID"));
                wfirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                wlastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                wEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
                wreturn_date.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
            }
        });
    }



    // Method to fetch rentals of the selected book
    private List<Rented_Book> fetchRentals(Book selectedBook) {
        return selectedBook.getRented_books();
    }



    private List<Orderd_Book> fetchWaitlist(Book selectedBook) {
        return selectedBook.getOrderd_books();
    }



    // method to fetch all books from library
    private List<Book> fetchAllBooks() {
        return HelloApplication.library.getBooks();
    }




    @FXML
    public void rentButtonHandler() {
        // Get the selected item from the waitingtable
        Orderd_Book selectedBook = waitingtable.getSelectionModel().getSelectedItem();
        if (selectedBook != null ) {
            // Get the reader associated with the selected book
            Reader reader = HelloApplication.library.findReaderById(selectedBook.ID);
            // Remove the selected book from the waitinglist
            waitingtable.getItems().remove(selectedBook);
            // Create a new Rented_Book with the selected book details and rent date
            Rented_Book rentedBook = new Rented_Book(selectedBook.getTitle(), selectedBook.getAuthor(), selectedBook.getISBN(), selectedBook.getGenre(), selectedBook.isAvailable(),reader.getFirstName(), reader.getLastName(),reader.getEmail(),reader.getID(),selectedBook.getReturnDate() );
            // Add the rented book to the reader's rented books list
            reader.addrentBook(rentedBook);
            Book book = Library.findBookByRentBook(rentedBook,fetchAllBooks());
            assert book != null;
            book.getOrderd_books().remove(selectedBook);
            if ( book.getISBN() > 1 ) {
                book.setISBN(book.getISBN() - 1);
            }
            else {
                allbooks.getItems().remove(book);
                book.setAvailable(false);
            }

            book.getRented_books().add(rentedBook);
            // Update the rentals table view
            rentaltable.getItems().add(rentedBook);
            waitingtable.getItems().remove(selectedBook);
        }
    }

    public void removeFromWaitingList(Orderd_Book order) {
        order = waitingtable.getSelectionModel().getSelectedItem();
        selbook.getOrderd_books().remove(order);
        waitingtable.getItems().addAll(selbook.getOrderd_books());
        waitingtable.refresh();
        Reader reader = HelloApplication.library.findReaderById( order.ID );
        reader.getUser_orderd_books().remove(order);
    }


    public void blockReader(Rented_Book rentedBook_reader) {
        rentedBook_reader = rentaltable.getSelectionModel().getSelectedItem();
        Reader reader = HelloApplication.library.findReaderById(rentedBook_reader.ID);
        reader.setBlocked(true);
    }




}
