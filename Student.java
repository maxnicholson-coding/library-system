public class Student {
    //initialize varaibles
    private String name;
    private int studentID;
    public Student(String name, int id) {
        //set varaibles
        this.name = name;
        studentID = id;
    }
    public String getName() { //returns the student's name
        return name;
    }
    public int getID() { // returns the student's ID number
        return studentID;
    }
    public String toString() { //returns student's info
        return ("Name: " + name + "\nID: " + studentID);
    }
}
