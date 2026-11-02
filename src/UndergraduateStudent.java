package model;

public class UndergraduateStudent extends Student {

    public UndergraduateStudent(int id, String name, String email,
                                String studentNumber, String program) {
        super(id, name, email, studentNumber, program);
    }

    @Override
    public double calculateGPA() {
        return 3.5;
    }
}
