package com.example.project_oop;

public class Librarian extends User{

    public Librarian(String Password,String FirstName, String LastName, String Address, String CellPhone, String Email) {
        super(Password, FirstName, LastName, Address, CellPhone, Email);
        setType("Librarian");
    }

    public void addBook(Book book) {
        // Add a book to the library
    }

    public void removeBook(Book book) {
        // Remove a book from the library
    }

    public void addUser(User user) {
        // Add a user to the library
    }

    public void removeUser(User user) {
        // Remove a user from the library
    }

    public void searchBooks() {
        // Search for books in the library
    }

    public void searchUsers() {
        // Search for users in the library
    }

    public void addToOrderList(User user, Book book) {
        // Add a user to the book order list
    }

    public void removeFromOrderList(User user, Book book) {
        // Remove a user from the book order list
    }

    public void blockUser(User user) {
        // Block a user from the library
    }

    public void rentBook(User user, Book book) {
        // Rent a book to a user
    }




}
