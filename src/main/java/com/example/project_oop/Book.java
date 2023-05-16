package com.example.project_oop;

public class Book {

    public static int count = 0;
    private String title;
    private String author;

    // number of copies
    private String ISBN;
    private String genre;

    private Boolean available;

    public Book(String title, String author, String ISBN, String genre , Boolean available) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.available = available;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
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






}

