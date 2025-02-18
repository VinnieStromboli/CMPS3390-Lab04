package Controlers;

import Models.Student;
import Models.StudentData;
import Views.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentController {
    private StudentData model;
    private StudentView view;

    public StudentController(StudentData model, StudentView view){
        this.model = model;
        this.view = view;

        ArrayList<Student> students = model.getStudents();

        students.forEach(s -> {
            view.addStudentToList(s.toString());
        });

        view.attachAddStudentListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = view.getFirstName();
                String lastName = view.getLastName();
                String studentID = view.getStudentId();

                if(firstName.isEmpty() || lastName.isEmpty() || studentID.isEmpty()){
                    return;
                }

                Student student = new Student(firstName, lastName, Integer.parseInt(studentID));
                model.addStudent(student);
                view.addStudentToList(student.toString());
                view.resetInputs();
            }
        });

        view.attachRemoveStudentListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = view.getSelectedStudentIndex();

                if(selectedIndex >= 0){
                    view.removeStudentFromList(selectedIndex);
                }
            }
        });
    }
}
