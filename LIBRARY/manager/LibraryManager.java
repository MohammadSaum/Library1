package manager;

import java.util.*;
import model.Book;
import model.User;

public class LibraryManager {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public void addUser(User u) {
        users.add(u);
    }

    public void viewAllBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public Book getBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        for (User u : users) {
            if (u.getUserId() == id) {
                return u;
            }
        }
        return null;
    }

    public void searchBookByTitle(String k) {
        String keyword = k.toLowerCase();
        boolean found = false;
        for (Book b : books) {
            String bTitle = b.getTitle().toLowerCase();
            if (bTitle.contains(keyword)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void borrowBook(int bookId, int userId) {
        Book b = getBookById(bookId);
        User u = getUserById(userId);
        
        if (b != null && u != null && b.getCopies() > 0) {
            u.borrowBook(bookId);
            b.setCopies(b.getCopies() - 1); 
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book unavailable or user not found.");
        }
    }

    public void returnBook(int bookId, int userId) {
        User u = getUserById(userId);
        Book b = getBookById(bookId);

        if (u != null && b != null) {
            if (u.getBorrowedBooks().contains(bookId)) {
                u.returnBook(bookId);
                b.setCopies(b.getCopies() + 1);
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("User did not borrow this book.");
            }
        } else {
            System.out.println("Invalid book or user.");
        }
    }
}
