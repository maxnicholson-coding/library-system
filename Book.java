public class Book {
    //initialize varaibles
    private String name;
    private String author;
    private int isbn;
    private String status;
    public Book (String name, String author, int isbn) {
        //set varaiables
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        status = "Checked Out";
    }
    public void checkout() { //checks out the book
        status = "Checked Out";
    }
    public void returnBook() { //returns the book
        status = "Availible";
    }
    public String toString() { // displays all info about the book
        return ("Title: " + name + "\nAuthor: " + author + "\nISBN: " + isbn + "\nCurrent Status: " + status);
    }
    public String getStatus() { //returns the book's status
        return status;
    }
}
