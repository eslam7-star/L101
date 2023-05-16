package com.example.project_oop;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.Arrays;


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
                new Book("ISBN001", "Title 1", "Author 1", "Genre 1", true),
                new Book("ISBN002", "Title 2", "Author 2", "Genre 2", false),
                new Book("ISBN003", "Title 3", "Author 3", "Genre 3", true)
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
    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getID() == userId) {
                return user;
            }
        }
        return null; // User not found
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
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null; // Book not found
    }

    public boolean checkLogin(String email, String password ) {
        if ( ! users.isEmpty() )
        {
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return true; // Login successful
                }
            }
        }
        return false; // Login failed
    }

}
