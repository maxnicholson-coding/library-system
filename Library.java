import java.util.ArrayList;
public class Library {
    //initialize varaibles
    private String name;
    public ArrayList<Book> allBooks;
    public ArrayList<Student> allStudents;
    public ArrayList<Loan> allLoans;
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
    public ArrayList getAllBooks() { //returns all books in the library
        return (allBooks);
    }
    public ArrayList getAllStudents() { //returns all students who've registered
        return (allStudents);
    }
    public ArrayList getAllLoans() { //returns all loans ever made
        return (allLoans);
    }
}
