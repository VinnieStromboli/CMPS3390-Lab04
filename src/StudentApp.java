import Models.StudentData;
import Views.StudentView;
import Controlers.StudentController;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentApp {
    public static void main(String[] args) {
        if(checkDrivers()) {
            StudentData model = new StudentData();
            StudentView view = new StudentView();
            new StudentController(model, view);

            view.setVisible(true);
        }
    }

    private static boolean checkDrivers()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new org.sqlite.JDBC());
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Could not start SQLite Driver!");
            return false;
        }
    }
}
