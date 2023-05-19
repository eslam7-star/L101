package com.example.project_oop;
import javafx.fxml.FXML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Library {

    private final ArrayList<User> users ;
    private final ArrayList<Book> books;

    public Library() {
        users = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new Reader("1234", "eslam", "ashraf", "addr", "0123","eslam@gmail.com"),
                new Librarian("1234", "adham", "ashraf", "addr", "0123","adham@gmail.com"),
                new Librarian("1234", "habiba", "ashraf", "addr", "0123","habiba@gmail.com")
        )));
        books = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new Book("Title 1", "Author 1", 4, "Genre 1", true),
                new Book("Title 2", "Author 2", 4, "Genre 2", true),
                new Book("Title 3", "Author 3", 4, "Genre 3", true)
        )));

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    @FXML
    public void addUser(User newUser) {
        // Add the new user to the data list
        users.add(newUser);

    }

    // Method to remove a user from the library
    public void removeUser(User user) {
        users.remove(user);
    }

    // Method to search for a user by ID
    public Reader findReaderById(int userId) {
        for (User user : users) {
            if (user.getID() == userId && user instanceof Reader ) {
                return (Reader)user;
            }
        }
        return null; // User not found
    }


    public static Book findBookByRentBook(Rented_Book rentedBook, List<Book> allBooks) {
        for (Book book : allBooks) {
            if (book.getTitle().equals(rentedBook.getTitle())) {
                return book;
            }
        }
        return null;
    }


    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }


    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to search for a book by ISBN
    public Book findBookByISBN(int isbn) {
        for (Book book : books) {
            if (book.getISBN() == isbn) {
                return book;
            }
        }
        return null; // Book not found
    }


    public User checkLogin(String email, String password , String type) {
        if ( ! users.isEmpty() )
        {
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password) && type.equals(user.getType())){
                    return user; // Login successful
                }
            }
        }
        return null; // Login failed
    }



    // return the id of the current user or zero for null
    public int get_User_id(User user){
        if ( !(user == null) )
            return user.getID();
        return 0;
    }


}
