
import database.StudentDAO;
import database.CourseDAO;
import database.EnrollmentDAO;
import model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

        int choice;

        do {
            System.out.println("\n===== UNIVERSITY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add Course");
            System.out.println("7. View All Courses");
            System.out.println("8. Delete Course");
            System.out.println("9. Enroll Student");
            System.out.println("10. View Student Enrollments");
            System.out.println("11. View All Enrollments");
            System.out.println("12. Delete Enrollment");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Full Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Student Number: ");
                    String studentNumber = scanner.nextLine();

                    System.out.print("Enter Program: ");
                    String program = scanner.nextLine();

                    Student student = new UndergraduateStudent(
                            id, name, email, studentNumber, program
                    );

                    studentDAO.addStudent(student);
                    break;

                case 2:
                    studentDAO.getAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student Number: ");
                    String searchNumber = scanner.nextLine();

                    studentDAO.searchStudent(searchNumber);
                    break;

                case 4:
                    System.out.print("Enter Student Number: ");
                    String updateNumber = scanner.nextLine();

                    System.out.print("Enter New Program: ");
                    String newProgram = scanner.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();

                    studentDAO.updateStudentWithTransaction(
                            updateNumber, newProgram, newEmail
                    );
                    break;

                case 5:
                    System.out.print("Enter Student Number: ");
                    String deleteNumber = scanner.nextLine();

                    studentDAO.deleteStudent(deleteNumber);
                    break;

                case 6:
                    System.out.print("Enter Course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Enter Credits: ");
                    int credits = scanner.nextInt();
                    scanner.nextLine();

                    Course course = new Course(
                            courseId, courseName, credits
                    );

                    courseDAO.addCourse(course);
                    break;

                case 7:
                    courseDAO.getAllCourses();
                    break;

                case 8:
                    System.out.print("Enter Course ID: ");
                    int deleteCourseId = scanner.nextInt();
                    scanner.nextLine();

                    courseDAO.deleteCourse(deleteCourseId);
                    break;

                case 9:
                    System.out.print("Enter Student ID: ");
                    int enrollStudentId = scanner.nextInt();

                    System.out.print("Enter Course ID: ");
                    int enrollCourseId = scanner.nextInt();
                    scanner.nextLine();

                    enrollmentDAO.enrollStudent(
                            enrollStudentId, enrollCourseId
                    );
                    break;

                case 10:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine();

                    enrollmentDAO.getStudentEnrollments(studentId);
                    break;

                case 11:
                    enrollmentDAO.getAllEnrollments();
                    break;

                case 12:
                    System.out.print("Enter Student ID: ");
                    int studentIdToDelete = scanner.nextInt();

                    System.out.print("Enter Course ID: ");
                    int courseIdToDelete = scanner.nextInt();
                    scanner.nextLine();

                    enrollmentDAO.deleteEnrollment(
                            studentIdToDelete, courseIdToDelete
                    );
                    break;

                case 0:
                    System.out.println("Thank you for using University Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
