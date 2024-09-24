package Views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class StudentView extends JFrame {
    private JPanel panel;
    private JList<String> studentList;
    private final DefaultListModel<String> studentListModel;
    private JTextField inputFirstName;
    private JTextField inputLastName;
    private JTextField inputStudentID;
    private JLabel labelFirstName;
    private JLabel labelLastName;
    private JLabel labelStudentID;
    private JButton addStudentButton;
    private JButton removeStudentButton;

    public StudentView(){
        setContentPane(panel);
        setTitle("Student App");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentListModel = new DefaultListModel<String>();
    }

    public String getFirstName(){
        return inputFirstName.getText();
    }

    public String getLastName(){
        return inputLastName.getText();
    }

    public String getStudentId(){
        return inputStudentID.getText();
    }

    public void resetInputs(){
        inputFirstName.setText("");
        inputLastName.setText("");
        inputStudentID.setText("");
    }

    public int getSelectedStudentIndex() {
        return studentList.getSelectedIndex();
    }

    public void addStudentToList(String student){
        studentListModel.addElement(student);
        studentList.setModel(studentListModel);
    }

    public void removeStudentFromList(int index) {
        if (index >= 0) {
            studentListModel.remove(index);
            studentList.setModel(studentListModel);
        }
    }

    public void attachAddStudentListener(ActionListener listener) {
        addStudentButton.addActionListener(listener);
    }

    public void attachRemoveStudentListener(ActionListener listener) {
        removeStudentButton.addActionListener(listener);
    }
}
