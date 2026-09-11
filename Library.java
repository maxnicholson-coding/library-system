import java.util.ArrayList;
public class Library {
    //initialize varaibles
    private String name;
    public ArrayList<Book> allBooks = new ArrayList<>();
    public ArrayList<Student> allStudents = new ArrayList<>();
    public ArrayList<Loan> allLoans = new ArrayList<>();
    public Library(String name) {
        this.name = name;
    }
    public void addBook(Book book) { //adds a book to the library
        allBooks.add(book);
    }
    public void addStudent(Student student) { //registers a student 
        allStudents.add(student);
    }
    public void addLoan(Loan loan) { //adds a loan to the library's records
        allLoans.add(loan);
    }
    public void checkoutBook(Book book, Student student) { //checks out a book
        book.checkout();
        //creates and records a loan
        Loan loan = new Loan(student, book);
        addLoan(loan);
    }
    public void returnBook(Book book, Loan loan) { //returns a book
        book.returnBook();
        //sets loan status to inactive
        loan.setStatus("Inactive");
    }
    public String getName() { //returns the name of the library
        return name;
    }
    public ArrayList getAllBooks() { //returns all books in the library
        return (allBooks);
    }
    public ArrayList getAllStudents() { //returns all students who've registered
        return (allStudents);
    }
    public ArrayList getAllLoans() { //returns all loans ever made
        return (allLoans);
    }
    public void printAllBooks() { //prints all books
        //checks if there are no books
        if (allBooks.isEmpty()) {
            System.out.println("There are currently no books.");
        } else {
            for (int i = 0; i < allBooks.size(); i++) {
                System.out.println(allBooks.get(i));
                System.out.println();
            }
        }
    }
    public void printAllStudents() { //prints all students
        //checks if there are no students
        if (allStudents.isEmpty()) {
            System.out.println("There are currently no students.");
        } else {
            for (int i = 0; i < allStudents.size(); i++) {
                System.out.println(allStudents.get(i));
                System.out.println();
            }
        }
    }
    public void printAllLoans() { //prints all loans
        //checks if there are no loans
        if (allLoans.isEmpty()) {
            System.out.println("There are currently no loans.");
        } else {
            for (int i = 0; i < allLoans.size(); i++) {
                System.out.println(allLoans.get(i));
                System.out.println();
            }
        }
    }
}
