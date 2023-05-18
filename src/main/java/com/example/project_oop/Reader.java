package com.example.project_oop;

import java.util.ArrayList;

public class Reader extends User {


    private ArrayList<Book> user_rented_books;
    private boolean isBlocked;



    public Reader(String Password, String FirstName, String LastName, String Address, String CellPhone, String Email) {
        super(Password, FirstName, LastName, Address, CellPhone, Email);
        this.isBlocked = false;
        setType("Reader");
        user_rented_books = new ArrayList<>();
//        Book book1 = new Book("Book 1", "Author 1", 1, "gen", true);
//        Book book2 = new Book("Book 2", "Author 2", 1, "gen", true);
//        Book book3 = new Book("Book 3", "Author 3", 1, "gen", true);
//        user_rented_books.add(book1);
//        user_rented_books.add(book2);
//        user_rented_books.add(book3);
    }


    public ArrayList<Book> getUser_rented_books() {
        return user_rented_books;
    }

    public void setUser_rented_books(ArrayList<Book> user_rented_books) {
        this.user_rented_books = user_rented_books;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }


    public void addToOrderList(Book book) {

    }



    public void addrentBook(Book book) {
        user_rented_books.add(book);

    }

    @Override
    public void rent() {

    }
}

