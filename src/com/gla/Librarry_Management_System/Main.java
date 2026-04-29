package Librarry_Management_System;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        LibraryService libraryService = new LibraryService(library.getLibraryRepository());

        AdminService adminService = new AdminService(libraryService);
        StudentService studentService = new StudentService(libraryService);

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n-------- LIBRARY MANAGEMENT MENU --------");
                System.out.println("1. ADMIN");
                System.out.println("2. STUDENT");
                System.out.println("3. EXIT.....");
                System.out.print("Enter Person: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        adminMenu(sc, adminService);
                        break;

                    case 2:
                        studentMenu(sc, studentService);
                        break;

                    case 3:
                        System.out.println("Exiting system...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println(" Invalid input! Please enter numbers only.");
                sc.nextLine();
            }
        }
    }


    public static void adminMenu(Scanner sc, AdminService adminService) {

        while (true) {
            try {
                System.out.println("\n----- ADMIN MENU -----");
                System.out.println("1. ADD BOOK : ");
                System.out.println("2. REMOVE BOOK : ");
                System.out.println("3. BOOK DETAILS : ");
                System.out.println("5. FACULTY : ");
                System.out.println("4. RETURN....");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Book ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Book Title : ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author Name : ");
                        String author = sc.nextLine();

                        System.out.print("Enter Publisher Name : ");
                        String publisher = sc.nextLine();

                        System.out.print("Enter Price Of Book : ");
                        int price = sc.nextInt();

                        System.out.println("Select Subject Of Book :");
                        for (Category c : Category.values()) {
                            System.out.println(c);
                        }

                        Category category = Category.valueOf(sc.next().toUpperCase());

                        Book book = new Book(id, title, author, publisher, price, category);
                        adminService.addBook(book);
                        break;

                    case 2:
                        System.out.print("Enter Book ID : ");
                        int removeId = sc.nextInt();
                        adminService.removeBook(removeId);
                        break;

                    case 3:
                        adminService.viewBooks();
                        break;

                    case 4:
                        return;

                    case 5:
                        System.out.println("Under Construction.....");

                    default:
                        System.out.println("Invalid choice.....");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category.... Please choose from list.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input.... Try again.");
                sc.nextLine();
            }
        }
    }

    public static void studentMenu(Scanner sc, StudentService studentService) {

        while (true) {
            try {
                System.out.println("\n_______-----_____ STUDENT MENU _____-----______");
                System.out.println("1. BOOKS : ");
                System.out.println("2. ISSUE BOOK : ");
                System.out.println("3. RETURN BOOK :");
                System.out.println("4. RETURN.....");
                System.out.println("5. Student Details :");
                System.out.println("6. Faculty Details :");
                System.out.println("7. Books Issued :" );
                System.out.println("8. Due Date of Books :");
                System.out.println("9. Fine : ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        studentService.viewBooks();
                        break;

                    case 2:
                        System.out.print("Enter Book ID to Issue: ");
                        int issueId = sc.nextInt();
                        studentService.issueBook(issueId);
                        break;

                    case 3:
                        System.out.print("Enter Book ID to Return: ");
                        int returnId = sc.nextInt();
                        studentService.returnBook(returnId);
                        break;

                    case 4:
                        return;

                    case 5:
                        System.out.println("Under Construction.....");

                    case 6:
                        System.out.println("Under Construction.....");

                    case 7:
                        System.out.println("Under Construction.....");

                    case 8:
                        System.out.println("Under Construction.....");

                    case 9:
                        System.out.println("Under Construction.....");

                    default:
                        System.out.println("Invalid choice......");
                }

            } catch (Exception e) {
                System.out.println("Invalid input...... Enter correct number.");
                sc.nextLine();
            }
        }
    }
}

