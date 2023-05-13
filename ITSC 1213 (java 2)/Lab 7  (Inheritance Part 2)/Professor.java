
import java.util.ArrayList;

public class Professor extends Person {
private String department;
private double salary;
private ArrayList<Student> advisees;

public Professor(String firstName, String lastName, int id, String department, double salary) {
    super(firstName, lastName, id);
    this.department = department;
    this.salary = salary;
    this.advisees = new ArrayList<Student>();
}

public String getDepartment() {
    return department;
}

public double getSalary() {
    return salary;
}

public ArrayList<Student> getAdvisees() {
    return advisees;
}

public void setDepartment(String department) {
    this.department = department;
}

public void setSalary(double salary) {
    this.salary = salary;
}

public void addAdvisee(Student student) {
    advisees.add(student);
}

public boolean removeAdvisee(int studentId) {
    for (int i = 0; i < advisees.size(); i++) {
        Student advisee = advisees.get(i);
        if (advisee.getId() == studentId) {
            advisees.remove(i);
            return true;
        }
    }
    return false;
}

public String getFirstNameOfProfessor() {
    return super.getFirstName();
}

public String getLastNameOfProfessor() {
    return super.getLastName();
}
@Override
public void display() {
    super.display();
    System.out.println("Department: " + department + "\tSalary: " + salary);
    System.out.println("Advisees:");
    for (Student student : advisees) {
        System.out.println("\t" + student.getFirstName() + " " + student.getLastName());
    }
}

@Override
    public String toString() {
        return "Professor - " + this.getFirstName() + " " + this.getLastName();
    }
}