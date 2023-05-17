package com.example.project_oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;



public class LibraryController implements Initializable {


    @FXML
    public ComboBox<String> Type;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField isbnField;
    @FXML
    public Button removeuser;
    @FXML
    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public TextField addressTextField;
    public TextField cellPhoneTextField;
    public TextField emailTextField;
    public Button adduser;
    public Button removebook;
    public Button addbook;

    @FXML
    private FilteredList<User> filteredUsers;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TextField authorField;

    @FXML
    private TableColumn<Book, Boolean> availableColumn;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableView<User> userstable;


    @FXML
    private TableColumn<Book, String > genreColumn;

    @FXML
    private TextField genreField;

    @FXML
    private TableColumn<Book, Integer> isbnColumn;

    @FXML
    private TextField searchText,searchtext2;

    @FXML
    private TextField quantityField;

    @FXML
    private Button searchBookButton;

    @FXML
    private Button searchUserButton;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TextField titleField;

    @FXML
    private TableColumn<User, String> Address;

    @FXML
    private TableColumn<User, String> Email;

    @FXML
    private TableColumn<User, Integer> ID;

    @FXML
    private TableColumn<User, String> firstname;

    @FXML
    private TableColumn<User, String> lastname;

    @FXML
    private TableColumn<User, String> phone;

    @FXML
    private TableColumn<User, String> type;

    private ObservableList<User> allUsers;
    private ObservableList<Book> allbooks;

    private User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstname.setCellValueFactory(new PropertyValueFactory<User,String>("firstName"));
        lastname.setCellValueFactory(new PropertyValueFactory<User,String>("lastName"));
        Address.setCellValueFactory(new PropertyValueFactory<User,String>("Address"));
        Email.setCellValueFactory(new PropertyValueFactory<User,String>("Email"));
        ID.setCellValueFactory(new PropertyValueFactory<User,Integer>("ID"));
        type.setCellValueFactory(new PropertyValueFactory<User,String>("Type"));
        phone.setCellValueFactory(new PropertyValueFactory<User,String>("phone"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("ISBN"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("genre"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<Book,Boolean>("available"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        allUsers = FXCollections.observableArrayList(HelloApplication.library.getUsers());
        userstable.getItems().addAll(HelloApplication.library.getUsers());
        allbooks = FXCollections.observableArrayList(HelloApplication.library.getBooks());
        bookTable.getItems().addAll(allbooks);

    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    public void searchUser() {
        if (!searchText.getText().isEmpty()) {
            // Create a filtered list to store the search results
            ObservableList<User> searchResults = FXCollections.observableArrayList();
            // Search for users with matching email, ID, or first name
            for (User user : allUsers) {
                if (user.getEmail().toLowerCase().contains(searchText.getText().trim()) ||
                        String.valueOf(user.getID()).contains(searchText.getText().trim()) ||
                        user.getFirstName().toLowerCase().contains(searchText.getText().trim())) {
                    searchResults.add(user);
                }
            }
            // Set the search results as the new data source for the table view
            userstable.setItems(searchResults);
        }else
        {
            userstable.setItems(allUsers);
        }
    }



    @FXML
    private void searchBook() {
        String searchTerm = searchtext2.getText().trim(); // Get the search term from the text field
        if(!searchTerm.isEmpty())
        {
            // Clear previous search results
            bookTable.getItems().clear();
            // Iterate through the books list and search for matching attributes
            for (Book book : HelloApplication.library.getBooks()) {
                if (book.getTitle().equalsIgnoreCase(searchTerm) ||
                        book.getGenre().equalsIgnoreCase(searchTerm) ||
                        book.getAuthor().equalsIgnoreCase(searchTerm)) {
                    // If any attribute of the book matches the search term, add it to the search results
                    bookTable.getItems().add(book);
                }
        }
    }else
        {
            bookTable.setItems(allbooks);
        }
    }


    @FXML
    void removeUser() {
        User selectedUser = userstable.getSelectionModel().getSelectedItem();
        if (selectedUser != null && selectedUser != user) {
            // Remove the user from the library
            HelloApplication.library.removeUser(selectedUser);
            // Remove the user from the observable list
            allUsers.remove(selectedUser);
        }
        userstable.getItems().clear();
        userstable.getItems().addAll(allUsers);
    }


    @FXML
    void addUser() {
        User newUser;
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String address = addressTextField.getText();
        String cellPhone = cellPhoneTextField.getText();
        String email = emailTextField.getText();
        String password = pass.getText();
        String type ;
        type = Type.getValue(); // Get the selected user type from the ComboBox
        if (type != null) {
            if (type.equals("Reader")) {
                newUser = new Reader(password, firstName, lastName, address, cellPhone, email);
            } else {
                newUser = new Librarian(password, firstName, lastName, address, cellPhone, email);
            }
            HelloApplication.library.addUser(newUser);
            // Add the new user to the observable list
            allUsers.add(newUser);
            clearUserFields();
            userstable.getItems().clear();
            userstable.getItems().addAll(allUsers);
        } else {
            System.out.println("please select a Type");
        }
    }

    private void clearUserFields() {
        firstNameTextField.clear();
        lastNameTextField.clear();
        addressTextField.clear();
        cellPhoneTextField.clear();
        emailTextField.clear();
        pass.clear();
    }

    private void clearBookFields() {
        titleField.clear();
        genreField.clear();
        authorField.clear();
    }

    @FXML
    void addBook() {
        String title = titleField.getText();
        String inputText = isbnField.getText();
        int isbn = 1;
        try {
            isbn = Integer.parseInt(inputText);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
        String genre = genreField.getText();
        String author = authorField.getText();
        Book newBook = new Book(title,author,isbn,genre,true);
        // Add the new book to the library
        HelloApplication.library.addBook(newBook);
        // Add the new book to the observable list
        allbooks.add(newBook);
        clearBookFields();
        bookTable.getItems().clear();
        bookTable.getItems().addAll(allbooks);
    }


    @FXML
    void removeBook() {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null && selectedBook.getISBN() == 1 ) {
            // Remove the book from the library
            HelloApplication.library.removeBook(selectedBook);

            // Remove the book from the observable list
            allbooks.remove(selectedBook);
        }else {
            assert selectedBook != null;
            int val = selectedBook.getISBN() - 1;
            selectedBook.setISBN(val);
        }
        bookTable.getItems().clear();
        bookTable.getItems().addAll(allbooks);
    }



















}
