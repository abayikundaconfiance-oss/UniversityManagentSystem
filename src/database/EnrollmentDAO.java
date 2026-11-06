
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentDAO {

    public void enrollStudent(int studentId, int courseId) {

        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);
            statement.setInt(2, courseId);

            statement.executeUpdate();

            System.out.println("Student enrolled successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStudentEnrollments(int studentId) {

        String sql = "SELECT c.course_id, c.course_name, c.credits "
                + "FROM enrollments e "
                + "JOIN courses c ON e.course_id = c.course_id "
                + "WHERE e.student_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                System.out.println("Course ID: " + result.getInt("course_id"));
                System.out.println("Course Name: " + result.getString("course_name"));
                System.out.println("Credits: " + result.getInt("credits"));
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEnrollment(int studentId, int courseId) {

        String sql = "DELETE FROM enrollments WHERE student_id = ? AND course_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, studentId);
            statement.setInt(2, courseId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Enrollment deleted successfully!");
            } else {
                System.out.println("Enrollment not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllEnrollments() {

        String sql = "SELECT s.first_name, s.last_name, "
                + "c.course_name, c.credits "
                + "FROM enrollments e "
                + "JOIN students s ON e.student_id = s.student_id "
                + "JOIN courses c ON e.course_id = c.course_id";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                System.out.println("Student: "
                        + result.getString("first_name") + " "
                        + result.getString("last_name"));

                System.out.println("Course: "
                        + result.getString("course_name"));

                System.out.println("Credits: "
                        + result.getInt("credits"));

                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

