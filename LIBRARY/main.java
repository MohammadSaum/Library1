import java.util.*;

import model.*;
import manager.LibraryManager;
import manager.LoginManager;

public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LibraryManager library = new LibraryManager();
        LoginManager l = new LoginManager();

        User currentUser=null;
        while(currentUser==null){
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice=sc.nextInt();
            if(choice==1){
                System.out.println("Username: ");
                String username = sc.next();
                System.out.println("Password: ");
                String password = sc.next();
                currentUser=l.login(username, password, library.getAllUsers());
                if(currentUser==null){
                    System.out.println("Invalid Username or Password, Try Again");
                }

            }else if(choice==2){
                System.out.println("Name: ");
                String name = sc.nextLine();
                System.out.println("Username: ");
                String username = sc.next();
                System.out.println("Password: ");
                String password = sc.next();
                int userId =1000+new Random().nextInt(9000);
                User newUser = new User(userId, name, username, password, false);
                library.addUser(newUser);
                System.out.println("User Registered Successfully, Now You can Login");

            }
            else if(choice==3){
                System.out.println("GoodBye!!");
                return;
            }
            else{
                System.out.println("Invalid Choice, Try Again !!");
            }
            
        }
        System.out.println("Welcome "+currentUser.getName());
        int choice;
        do{
            System.out.println("=========Menu=========");
            if(currentUser.getIsAdmin()){
                System.out.println("1. Add Book");
                System.out.println("2. View Book");
                System.out.println("3. View User");
                System.out.println("4. Logout");
                choice=sc.nextInt();
                if(choice==1){
                    System.out.println("Book Title: ");
                    String title = sc.nextLine();
                    System.out.println("Book Author: ");
                    String author = sc.nextLine();
                    System.out.println("Publisher: ");
                    String publisher = sc.nextLine();
                    System.out.println("Book year: ");
                    int year = sc.nextInt();
                    System.out.println("Copies: ");
                    int copies = sc.nextInt();
                    int bookId=1000+new Random().nextInt(9000);
                    Book newBook = new Book (bookId, title, author, publisher, year, copies,copies);
                    library.addBook(newBook);
                    System.out.println();
                    System.out.println("Book Added Successfully");
                }else if(choice==2){
                    System.out.println("=====Book list=====");
                    library.viewAllBooks();
                }else if(choice==3){
                    System.out.println("=====User List=====");
                    ArrayList<User> users=library.getAllUsers();
                    for(User u:users){
                        String role;
                        if(u.getIsAdmin()){
                            role = "Admin";
                        }else{
                            role = "User";
                        }
                        System.out.println(u.getUserId()+": "+u.getName()+" | Role: "+role);
                    }

                }else if(choice==4){
                    System.out.println("GoodBye!!!!");
                    return;
                }else{
                    System.out.println("Invalid Choice, Try Again");
                    return;
                }
            }else{
                System.out.println("1. View Book");
                System.out.println("2. Search Book");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. My Borrowed Book");
                System.out.println("6. Logout");
                choice=sc.nextInt();
                if (choice==1){
                    System.out.println("======Book List=====");
                    library.viewAllBooks();
                }else if(choice==2){
                    System.out.println("Keyword: ");
                    String keyword=sc.nextLine();
                    library.searchBookByTitle(keyword);
                }else if(choice==3){
                    System.out.println("Book ID: ");
                    int bookID = sc.nextInt();
                    library.borrowBook(bookID, currentUser.getUserId());
                }else if(choice==4){
                    System.out.println("Book ID: ");
                    int bookID = sc.nextInt();
                    library.returnBook(bookID, currentUser.getUserId());
                }else if(choice==5){
                    currentUser.showBorrowedBooks();
                }else if (choice==6){
                    System.out.println("======Logged Out======");
                }else{
                    System.out.println("Invalid Choice, Try Again");
                }
            }
        }while (true);
    } 
    
    
}