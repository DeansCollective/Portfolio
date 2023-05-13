/**
The Person class's subclass Professor represents a professor object, which includes a department, a salary, and a list of advisees.
@author Dean
*/
import java.util.ArrayList;

public class Professor extends Person {
private String department;
private double salary;
private ArrayList<Student> advisees;
/**
 * Constructor for Professor with these params.
 * @param firstName 
 * @param lastName 
 * @param id 
 * @param department 
 * @param salary 
 */
public Professor(String firstName, String lastName, int id, String department, double salary) {
    super(firstName, lastName, id);
    this.department = department;
    this.salary = salary;
    this.advisees = new ArrayList<Student>();
}

/**
 * Getter method to return department.
 * @return department
 */
public String getDepartment() {
    return department;
}

/**
 * Getter method for salary.
 * @return salary
 */
public double getSalary() {
    return salary;
}

/**
 * Getter method for advisees.
 * @return  advisees
 */
public ArrayList<Student> getAdvisees() {
    return advisees;
}

/**
 * Setter method for department.
 * @param department 
 */
public void setDepartment(String department) {
    this.department = department;
}

/**
 * Setter method for salary.
 * @param salary 
 */
public void setSalary(double salary) {
    this.salary = salary;
}

/**
 * Adds advisee to the list of advisees.
 * @param student Student to add
 */
public void addAdvisee(Student student) {
    advisees.add(student);
}

/**
 * Removes advisee from the list of advisees.
 * @param studentId Student id to remove
 * @return boolean value
 */
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

/**
 * Getter method to return first name of professor.
 * @return first name of professor
 */
public String getFirstNameOfProfessor() {
    return super.getFirstName();
}

/**
 * Getter method to return last name of professor.
 * @return last name of professor
 */
public String getLastNameOfProfessor() {
    return super.getLastName();
}

}