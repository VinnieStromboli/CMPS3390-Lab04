package Models;

public class Student {
    private final String firstName;
    private final String lastName;
    private final int studentID;

    public Student(String firstName, String lastName, int studentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public String toString(){
        return String.format("%s %s (%d)", firstName, lastName, studentID);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentID() {
        return studentID;
    }
}
