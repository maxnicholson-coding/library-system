public class Loan {
    //initialize variables
    private Student student;
    private Book book;
    private String status;
    public Loan (Student student, Book book) {
        this.student = student;
        this.book = book;
        status = "Active";
    }
    public String toString() { // describes the loan
        return (student.getName() + " has loaned out " + book.getName() + ".\nThe status of the loan is currently " + status + ".");
    }
    public Book getBook() { //returns the book being loaned
        return book;
    }
    public void setStatus(String newStatus) { // sets the status of the loan
        status = newStatus;
    }
    public String getStatus() { // returns the status of the loan
        return status;
    }
}
