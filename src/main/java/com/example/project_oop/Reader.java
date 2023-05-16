package com.example.project_oop;

public class Reader extends User {

    private boolean isBlocked;

    public Reader(String Password, String FirstName, String LastName, String Address, String CellPhone, String Email) {
        super(Password, FirstName, LastName, Address, CellPhone, Email);
        this.isBlocked = false;
        setType("Reader");
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void searchBooks() {
        // Search for books in the library
    }

    public void searchUsers() {
        // Search for users in the library
    }

    public void addToOrderList(Book book) {
        // Add the reader to the book order list
    }

    public void rentBook(Book book) {
        // Rent a book from the library

    }



}

