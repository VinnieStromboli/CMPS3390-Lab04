package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentData {
    private final String db = "jdbc:sqlite:sqlite.db";

    public StudentData() {
        try (Connection conn = DriverManager.getConnection(db)) {
            Statement stmt = conn.createStatement();
            stmt.execute("""
                    create table if not exists Student (
                        id int not null unique,
                        firstName varchar(50) not null,
                        lastName varchar(50) not null
                    );
                    """);
            stmt.close();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void addStudent(Student student) {
        try (Connection conn = DriverManager.getConnection(db)) {
            String query = "INSERT INTO Student (id, firstName, lastName) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, student.getStudentID());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void removeStudent(Student student) {
        try (Connection conn = DriverManager.getConnection(db)) {
            String query = "DELETE FROM Student WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, student.getStudentID());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students;

        try (Connection conn = DriverManager.getConnection(db)) {
            String query = "SELECT * FROM Student";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(query);

            students = new ArrayList<>();
            while (set.next())
            {
                Student s = new Student(
                        set.getString("firstName"),
                        set.getString("lastName"),
                        set.getInt("id")
                        );

                students.add(s);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return students;
    }
}