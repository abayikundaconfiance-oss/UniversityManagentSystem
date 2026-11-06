
package database;

import model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAO {

    public void addCourse(Course course) {

        String sql = "INSERT INTO courses (course_id, course_name, credits) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, course.getCourseId());
            statement.setString(2, course.getCourseName());
            statement.setInt(3, course.getCredits());

            statement.executeUpdate();

            System.out.println("Course added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllCourses() {

        String sql = "SELECT * FROM courses";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {

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

    public void deleteCourse(int courseId) {

        String sql = "DELETE FROM courses WHERE course_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, courseId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Course deleted successfully!");
            } else {
                System.out.println("Course not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

