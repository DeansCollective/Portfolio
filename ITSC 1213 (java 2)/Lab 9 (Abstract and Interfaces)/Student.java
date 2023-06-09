import java.util.ArrayList;
import java.util.Collections;
import java.util.*;


public class Student extends Person {

    private String department;
    private double salary;
    private String major;
    private double gpa;
    private int credits;
    private boolean transfer;
    private double balance;
    private ArrayList<String> enrolledCourses;

    public Student(String fName, String lName, int id, String major, double gpa, int credits) {
        super(fName, lName, id);
        this.major = major;
        this.gpa = gpa;
        this.credits = credits;
        balance = 0;
        enrolledCourses = new ArrayList();
    }

    public void addCourse(String course) {
        enrolledCourses.add(course);

    }

    public boolean dropCourse(String course) {
        boolean drop = false;
        for (String c : enrolledCourses) {
            if (c.equalsIgnoreCase(course)) {
                enrolledCourses.remove(c);
                return true;
            }
        }
        return drop;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override 
    public void display() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName() + "     ID: " + this.getId());
        System.out.println("Department: " + department + "\tsalary: " + salary);
        // System.out.println("ID: " + this.getId() + "\tMajor: " + major);
        // System.out.println("ID: " + this.getId() + "\tMajor: " + major);
        // System.out.println("GPA: " + gpa + "\tCredits Applied: " + credits);
        // System.out.println("Enrolled Courses:");

        // for (int i = 0; i < enrolledCourses.size(); i++) {
        //     System.out.println("\t" + enrolledCourses.get(i));
        // }

    }

    @Override public String toString() {
        return "Student - " + this.getFirstName() + " " + this.getLastName();
    }

    public int compareTo(Student o) {
        double sGPA = this.getGPA();
        double oGPA = o.getGPA();
    
        if (sGPA > oGPA) {
            return 1;
        } else if (sGPA < oGPA) {
            return -1;
        } else {
            return 0;
        }
    }
    
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public String getName() {
        if (name == null) {
            return "";
        }
        return name;
    }
    

    public int getAge() {
        return age;
    }

}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
    
}





