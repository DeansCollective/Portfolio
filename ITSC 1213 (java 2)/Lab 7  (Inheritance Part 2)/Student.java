
import java.util.ArrayList;
public class Student extends Person {
private String major;
private double gpa;
private int credits;
private double balance;
private boolean transfer;
private ArrayList<String> enrolledCourses;

public Student(String firstName, String lastName, int id, String major, double gpa, int credits) {
    super(firstName, lastName, id);
    this.major = major;
    this.gpa = gpa;
    this.credits = credits;
    balance = 0;
    this.enrolledCourses = new ArrayList<String>();
}


public String getMajor(){
    return major;
}

public double getGPA(){
    return gpa;
}

public int getCredits(){
    return credits;
}

public boolean isTransfer(){
    return transfer;
}

public double getBalance(){
    return balance;
}

public ArrayList<String> getEnrolledCourses(){
    return enrolledCourses; 
}

public void setMajor(String major){
    this.major = major;
}

public void setGPA(double gpa) {
    this.gpa = gpa;
}

public void setCredits(int credits) {
    this.credits = credits;
}

public void setTransfer(boolean transfer) {
    this.transfer = transfer;
}

public void setBalance(double balance) {
    this.balance = balance;
}

public void addCourse(String courseName) {
enrolledCourses.add(courseName);
}

public boolean dropCourse(String courseName) {
return enrolledCourses.remove(courseName);
}

@Override
    public void display() {
        super.display(); 
        System.out.println("ID: " + getId() + "\tMajor: " + major);
        System.out.println("GPA: " + gpa + "\tCredits Applied: " + credits);
        System.out.println("Enrolled Courses: ");
        for (String course : enrolledCourses) {
            System.out.println(course);
        }
    }
    @Override
    public String toString() {
        return "Student - " + this.getFirstName() + " " + this.getLastName();
    }
}