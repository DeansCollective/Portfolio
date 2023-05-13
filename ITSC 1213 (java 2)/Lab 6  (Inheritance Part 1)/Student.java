/**

A student object with a major, GPA, number of credits, balance, transfer status, and courses attended is represented by the Student class, a subclass of the Person class.
@author Dean
*/
import java.util.ArrayList;
public class Student extends Person {
private String major;
private double gpa;
private int credits;
private double balance;
private boolean transfer;
private ArrayList<String> enrolledCourses;
/**
 * Constructor for Student with these params. 
 * @param firstName 
 * @param lastName 
 * @param id 
 * @param major 
 * @param gpa 
 * @param credits 
 */
public Student(String firstName, String lastName, int id, String major, double gpa, int credits) {
    super(firstName, lastName, id);
    this.major = major;
    this.gpa = gpa;
    this.credits = credits;
    balance = 0;
    this.enrolledCourses = new ArrayList<String>();
}

/**
 * Getter method to return major.
 * @return major
 */
public String getMajor(){
    return major;
}

/**
 * Getter method for GPA.
 * @return  GPA
 */
public double getGPA(){
    return gpa;
}

/**
 * Getter for credits
 * @return credits
 */
public int getCredits(){
    return credits;
}

/**
 * Getter method for transfer status
 * @return true if the student is a transfer student if not it is false
 */
public boolean isTransfer(){
    return transfer;
}

/**
 * Getter method for account balance.
 * @return account balance
 */
public double getBalance(){
    return balance;
}

/**
 * Getter method courses student is enrolled in.
 * @return courses
 */
public ArrayList<String> getEnrolledCourses(){
    return enrolledCourses; 
}

/**
 * Setter method for major.
 * @param major 
 */
public void setMajor(String major){
    this.major = major;
}

/**
 * Setter method for GPA.
 * @param gpa  GPA
 */
public void setGPA(double gpa) {
    this.gpa = gpa;
}

/**
 * Setter method for credits
 * @param credits 
 */
public void setCredits(int credits) {
    this.credits = credits;
}

/**
 * Setter method for transfer status.
 * @param transfer boolean value for transfer student
 */
public void setTransfer(boolean transfer) {
    this.transfer = transfer;
}

/**
 * Setter method for account balance.
 * @param balance for balance
 */
public void setBalance(double balance) {
    this.balance = balance;
}

/**
Adds course to the list of courses
@param add to the list of courses.
*/
public void addCourse(String courseName) {
enrolledCourses.add(courseName);
}

/**
Removescourse from the list
@param courseName
@return boolean value
*/
public boolean dropCourse(String courseName) {
return enrolledCourses.remove(courseName);
}
}