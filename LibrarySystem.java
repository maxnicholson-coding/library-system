import java.util.Scanner;
public class LibrarySystem
{
    //initialize some helpful things; probably inefficient but it works
    public static Scanner input = new Scanner(System.in);
    public static Book recentLoanedBook;
    public static Student recentLoaner;
    public static Loan recentLoan;
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Library System.");
        //take input of library name
        System.out.println("What is the name of your library?");
        String libraryName = input.nextLine();
        //crate library object
        Library library = new Library(libraryName);
        System.out.println("Welcome to " + libraryName + ". For a list of commands, please type \"help\".");
        //starts taking input
        libraryInput(library);
    }
    public static void libraryInput(Library library) { //takes an input and preforms the corresponding action
        while (true) {
            System.out.println("\nPlease make an input.");
            String command = input.nextLine();
            if (command.equals("help")) {
                System.out.println("List of commands: new book, register, loan, return, check, goodbye");
            } else if (command.equals("new book")) {
                createNewBook(library);
            } else if (command.equals("register")) {
                registerStudent(library);
            } else if (command.equals("loan")) {
                makeLoan(library);
            } else if (command.equals("return")) {
                returnBook(library);
            } else if (command.equals("check")) {
                checkLibrary(library);
            } else if (command.equals("goodbye")) {
                System.out.println("Goodbye! Come back to " + library.getName() + " soon!");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
    public static void createNewBook(Library library) { //creates new book and adds it to the library
        //get book info
        System.out.println("What is this book's name?");
        String bookName = input.nextLine();
        System.out.println("What is this book's author?");
        String bookAuthor = input.nextLine();
        System.out.println("What is this book's ISBN?");
        int bookISBN = input.nextInt();
        input.nextLine();
        //add book to the library
        Book book = new Book(bookName, bookAuthor, bookISBN);
        library.addBook(book);
        System.out.println(bookName + " added to the library.");
    }
    public static void registerStudent(Library library) { //registers a new student to the library
        //get student info
        System.out.println("What is this student's name?");
        String studentName = input.nextLine();
        System.out.println("What is this stuednt's ID number?");
        int studentID = input.nextInt();
        input.nextLine();
        //registers student
        Student student = new Student(studentName, studentID);
        library.addStudent(student);
        System.out.println(studentName + " registered to the library.");
    }
    public static void makeLoan(Library library) { //loans out a book to a student
        //check if a loan is possible
         if (checkCanLoan(library)) {
            //take book being loaned
            System.out.println("What book is being loaned?");
            String loanedBook = input.nextLine();
            //check availablilty
            if (checkBookAvailable(library, loanedBook)) {
                //take a student's ID
                System.out.println("What is the ID of the student recieving the book?");
                int loanerID = input.nextInt();
                input.nextLine();
                //if the ID matches, complete the loan
                if (checkStudentRegister(library, loanerID)) {
                    library.checkoutBook(recentLoanedBook, recentLoaner);
                    System.out.println("Loan successfully made.");
                } else {
                    System.out.println("Student not found.");
                }
            } else {
                System.out.println("Book not found.");
            }
        } else {
            System.out.println("A loan is impossible");
        }
    }
    public static void returnBook(Library library) { //returns a checked out book
        //take inputted book
        System.out.println("What book is getting returned");
        String bookName = input.nextLine();
        //find it in the library
        if (isBookPresent(library, bookName)) {
            if (findLoan(library, recentLoanedBook)) {
                recentLoan.setStatus("Inactive");
                recentLoanedBook.returnBook();
            } else {
                System.out.println("Loan not found.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }
    public static boolean checkBookAvailable(Library library, String book) { //checks if a book with a given name is availible
        for (int i = 0; i < library.allBooks.size(); i++) {
            Book currentBook = library.allBooks.get(i);
            //checks if name matches and is availble for each book
            if ((currentBook.getName().equals(book)) && (currentBook.getStatus().equals("Available"))) {
                recentLoanedBook = currentBook;
                return true;
            }
        }
        //return false if none there
        return false;
    }
    public static boolean checkStudentRegister(Library library, int num) { //checks if a student with a given id is registered
        for (int i = 0; i < library.allStudents.size(); i++) {
            Student currentStudent = library.allStudents.get(i);
            //check if each student has a matching id
            if (currentStudent.getID() == num) {
                recentLoaner = currentStudent;
                return true;
            }
        }
        //returns false if no matches
        return false;
    }
    public static boolean checkCanLoan(Library library) { //check is a loan is possible
        boolean canLoan = false;
        //check if the library has an availible book
        for (int i = 0; i < library.allBooks.size(); i++) {
            Book currentBook = library.allBooks.get(i);
            if (currentBook.getStatus().equals("Available")) {
                canLoan = true;
            }
        }
        //check is there is a student to loan to
        if (library.allStudents.isEmpty()) {
            canLoan = false;
        }
        return canLoan;
    }
    public static boolean isBookPresent(Library library, String bookName) { //checks if a book is in a library
        for (int i = 0; i < library.allBooks.size(); i++) {
            Book currentBook = library.allBooks.get(i);
            //check if each book matches the requested one
            if (bookName.equals(currentBook.getName())) {
                //sets that to currentLoanedBook
                recentLoanedBook = currentBook;
                return true;
            }
        }
        //returns false if no matches
        return false;
    }
    public static boolean findLoan(Library library, Book book) { //finds what loan the book is a part
        for (int i = 0; i < library.allLoans.size(); i++) {
            Loan currentLoan = library.allLoans.get(i);
            //checks if the loan is of the book
            if ((currentLoan.getBook()).equals(book)) {
                recentLoan = currentLoan;
                return true;
            }
        }
        //returns false if none found
        return false;
    }
    public static void checkLibrary(Library library) { //displays all books, students, or loans at the library
        System.out.println();
        //input what will be checked
        System.out.println("What do you want to check? (books, students, or loans)");
        //loops until an input is valid
        while (true) {
            String view = input.nextLine();
            if (view.equals("books")) {
                library.printAllBooks();
                break;
            } else if (view.equals("students")) {
                library.printAllStudents();
                break;
            } else if (view.equals("loans")) {
                library.printAllLoans();
                break;
            } else {
                System.out.println("Invalid input. Please type \"books\", \"students\" or \"loans\".");
            }
        }
    }
}
