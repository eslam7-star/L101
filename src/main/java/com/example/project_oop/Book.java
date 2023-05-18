package com.example.project_oop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {


    private ArrayList<Orderd_Book> orderd_books;
    private ArrayList<Rented_Book> rented_books;
    private ArrayList<Reader> rentals;
    private ArrayList<Reader> order_list;
    private ArrayList<LocalDate> return_Dates;
    private ArrayList<LocalDate> return_Dates_order_list;

    private LocalDate returndate;


    public static int count = 0;
    private String title;
    private String author;

    // number of copies
    private int ISBN;
    private String genre;

    private Boolean available;

    private Date return_date,rent_date;

    public Book(String title, String author, int ISBN, String genre , Boolean available) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.available = available;
        this.order_list = new ArrayList<>();
        this.return_Dates_order_list = new ArrayList<>();
        this.rentals =  new ArrayList<>();
        this.return_Dates =  new ArrayList<>();
        this.rented_books = new ArrayList<>();
        this.orderd_books = new ArrayList<>();

    }


    public ArrayList<Orderd_Book> getOrderd_books() {
        return orderd_books;
    }

    public void setOrderd_books(ArrayList<Orderd_Book> orderd_books) {
        this.orderd_books = orderd_books;
    }

    public ArrayList<Rented_Book> getRented_books() {
        return rented_books;
    }

    public void setRented_books(ArrayList<Rented_Book> rented_books) {
        this.rented_books = rented_books;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public void setReturndate(LocalDate returndate) {
        this.returndate = returndate;
    }

    public void add_to_orderlist(Reader reader){
        order_list.add(reader);
    }

    public void add_to_rentals(Reader reader){
        rentals.add(reader);
    }

    public void add_to_return_Dates(LocalDate LD){
        return_Dates.add(LD);
    }

    public void add_to_return_Dates_orderlists(LocalDate LD){
        return_Dates_order_list.add(LD);
    }



    public ArrayList<Reader> getRentals() {
        return rentals;
    }

    public void setRentals(ArrayList<Reader> rentals) {
        this.rentals = rentals;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Date getRent_date() {
        return rent_date;
    }

    public void setRent_date(Date rent_date) {
        this.rent_date = rent_date;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public static void increament(){
        count++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public ArrayList<Reader> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(ArrayList<Reader> order_list) {
        this.order_list = order_list;
    }


    public ArrayList<LocalDate> getReturn_Dates() {
        return return_Dates;
    }

    public void setReturn_Dates(ArrayList<LocalDate> return_Dates) {
        this.return_Dates = return_Dates;
    }

    public ArrayList<LocalDate> getReturn_Dates_order_list() {
        return return_Dates_order_list;
    }

    public void setReturn_Dates_order_list(ArrayList<LocalDate> return_Dates_order_list) {
        this.return_Dates_order_list = return_Dates_order_list;
    }

    public boolean isAvailable() {
        if ( ISBN < 1 ) {
            available = false;
            return false;
        }
        return true;
    }








}

