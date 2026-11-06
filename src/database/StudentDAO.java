
package database;

import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(Student student) {

        String sql = "INSERT INTO students "
                + "(first_name, last_name, email, student_number, program) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            String[] names = student.getName().split(" ", 2);

            statement.setString(1, names[0]);
            statement.setString(2, names.length > 1 ? names[1] : "");
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getStudentNumber());
            statement.setString(5, student.getProgram());

            statement.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents() {

        String sql = "SELECT * FROM students";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                System.out.println("ID: " + result.getInt("student_id"));
                System.out.println("First Name: " + result.getString("first_name"));
                System.out.println("Last Name: " + result.getString("last_name"));
                System.out.println("Email: " + result.getString("email"));
                System.out.println("Student Number: " + result.getString("student_number"));
                System.out.println("Program: " + result.getString("program"));
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentProgram(String studentNumber, String newProgram) {

        String sql = "UPDATE students SET program = ? WHERE student_number = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, newProgram);
            statement.setString(2, studentNumber);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String studentNumber) {

        String sql = "DELETE FROM students WHERE student_number = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, studentNumber);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchStudent(String studentNumber) {

        String sql = "SELECT * FROM students WHERE student_number = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, studentNumber);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("Student Found!");
                System.out.println("ID: " + result.getInt("student_id"));
                System.out.println("First Name: " + result.getString("first_name"));
                System.out.println("Last Name: " + result.getString("last_name"));
                System.out.println("Email: " + result.getString("email"));
                System.out.println("Student Number: " + result.getString("student_number"));
                System.out.println("Program: " + result.getString("program"));
            } else {
                System.out.println("Student not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateStudentWithTransaction(
            String studentNumber,
            String newProgram,
            String newEmail) {

        String sql = "UPDATE students SET program = ?, email = ? "
                + "WHERE student_number = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {

            connection.setAutoCommit(false);

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, newProgram);
                statement.setString(2, newEmail);
                statement.setString(3, studentNumber);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    connection.commit();
                    System.out.println("Transaction committed successfully!");
                } else {
                    connection.rollback();
                    System.out.println("Student not found! Transaction rolled back.");
                }

            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
