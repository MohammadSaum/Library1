package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int copies;
    private int totalCopies;

    public Book(int id, String title, String author, String publisher, int year, int copies, int totalCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.totalCopies = totalCopies;
        this.copies = copies;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
    this.copies = copies;
}


}
