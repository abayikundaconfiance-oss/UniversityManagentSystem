
import database.StudentDAO;
import model.*;

public class Main {

    public static void main(String[] args) {

        Student student = new UndergraduateStudent(
                3,
                "Peter Mugisha",
                "peter2@gmail.com",
                "ST005",
                "Software Engineering"
        );

        StudentDAO studentDAO = new StudentDAO();

        studentDAO.updateStudentWithTransaction(
                "ST003",
                "Computer Science",
                "peternew@gmail.com"
        );

        System.out.println("\nStudents from Database:");
        studentDAO.getAllStudents();

        System.out.println("\nSearching Student:");
        studentDAO.searchStudent("ST003");

        Student student1 = new UndergraduateStudent(
                1,
                "Alice",
                "alice@gmail.com",
                "ST001",
                "Computer Science"
        );

        Student student2 = new GraduateStudent(
                2,
                "John",
                "john@gmail.com",
                "ST002",
                "Software Engineering",
                "Artificial Intelligence"
        );

        UniversityManager manager = new UniversityManager();

        manager.addStudent(student1);
        manager.addStudent(student2);

        Course course1 = new Course(101, "Java Programming", 3);
        Course course2 = new Course(102, "Database Systems", 4);

        manager.addCourse(course1);
        manager.addCourse(course2);

        Instructor instructor1 = new Instructor(
                1,
                "Mr. James",
                "james@gmail.com",
                "INS001",
                "Computer Science"
        );

        Instructor instructor2 = new Instructor(
                2,
                "Mrs. Mary",
                "mary@gmail.com",
                "INS002",
                "Information Technology"
        );

        manager.assignInstructor(course1, instructor1);
        manager.assignInstructor(course2, instructor2);

        System.out.println("Students:");
        manager.displayStudents();

        System.out.println("\nCourses:");
        manager.displayCourses();

        System.out.println("\nInstructor Assignments:");
        manager.displayAssignments();
    }
}
