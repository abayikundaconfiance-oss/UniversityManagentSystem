
package model;

public class Student extends Person {

    private String studentNumber;
    private String program;

    public Student(int id, String name, String email,
                   String studentNumber, String program) {

        super(id, name, email);

        this.studentNumber = studentNumber;
        this.program = program;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", program='" + program + '\'' +
                '}';
    }

    @Override
    public void displayInfo() {
        System.out.println(toString());
    }
}
