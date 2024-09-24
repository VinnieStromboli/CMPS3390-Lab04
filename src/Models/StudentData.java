package Models;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
    private final List<Student> students;

    public StudentData() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}