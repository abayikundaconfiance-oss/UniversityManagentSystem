package model;

import java.util.*;

public class UniversityManager {

    private List<Student> students = new ArrayList<>();
    private Set<Course> courses = new HashSet<>();
    private Map<Course, Instructor> instructorAssignments = new HashMap<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void assignInstructor(Course course, Instructor instructor) {
        instructorAssignments.put(course, instructor);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void displayAssignments() {
        for (Map.Entry<Course, Instructor> entry : instructorAssignments.entrySet()) {
            System.out.println(entry.getKey() + " assigned to " + entry.getValue());
        }
    }
}