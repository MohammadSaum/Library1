package model;

import java.util.ArrayList;

public class User { 
    private int userId;
    private String name;
    private String userName;
    private String password;
    private boolean isAdmin;
    private ArrayList<Integer> borrowedBooks;

    public User(int id, String name, String userName, String password, boolean isAdmin) {
        this.userId = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
        this.borrowedBooks = new ArrayList<>(); 
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public ArrayList<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(int id) {
        borrowedBooks.add(id);
    }

    public void returnBook(int id) {
        borrowedBooks.remove(Integer.valueOf(id)); 
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            System.out.println("Borrowed books: " + borrowedBooks);
        }
    }
}
