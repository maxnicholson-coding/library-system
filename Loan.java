public class Loan {
    //initialize variables
    private Student student;
    private Book book;
    private String status;
    public Loan (Student student, Book book) {
        this.student = student;
        this.book = book;
        status = "Checked Out";
    }
    public String toString() { // describes the loan
        return (student + " has loaned out " + book + ".\nThe status of the loan is currently " + status + ".");
    }
    public void setStatus(String newStatus) { // setst the status of the loan
        status = newStatus;
    }
    public String getStatus() { // returns the status of the loan
        return status;
    }
}
