import Models.StudentData;
import Views.StudentView;
import Controlers.StudentController;

public class StudentApp {
    public static void main(String[] args) {
        StudentData model = new StudentData();
        StudentView view = new StudentView();
        new StudentController(model, view);

        view.setVisible(true);
    }
}
