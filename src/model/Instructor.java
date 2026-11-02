
package model;

public class Instructor extends Person {

    private String employeeNumber;
    private String department;

    public Instructor(int id, String name, String email,
                      String employeeNumber, String department) {

        super(id, name, email);

        this.employeeNumber = employeeNumber;
        this.department = department;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public void displayInfo() {
        System.out.println(toString());
    }
}
