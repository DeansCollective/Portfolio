import java.util.Collections;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Professor maryCastro = new Professor("Mary", "Castro", 300, "CS", 80000.0);
        maryCastro.display();

        List<Student> student = new ArrayList<Student>();


        Student s1 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        Student s2 = new Student("Kathrine", "Johnson", 900, "CS", 4.0, 100);
        Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        Student s4 = new Student("Kimberly", "Bryant", 902, "EE", 3.0, 80);
        // Student s5 = new Student("Dean", "Trojanowski", 903, "Math", 3.8, 87);


        int compareStudents = s4.compareTo(s1);
        System.out.println("Students GPA: " + s4.getGPA() + " and " + s1.getGPA() + " " + compareStudents);

        student.add(s1);
        student.add(s2);
        student.add(s3);
        student.add(s4);
        //student.add(s5);
    
        StudentComparator comparator = new StudentComparator();
        Collections.sort(student, comparator);

        for (Student s : student) {
            System.out.println(s);
        }
        // create a University instance
        University uncc = new University("UNC Charlotte");
        
        // create Student instances
        // Student s1 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        // Student s2 = new Student("Kathrine", "Johnson", 900, "CS", 4.0, 100);
        // Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        // Student s4 = new Student("Kimberly", "Bryant", 902, "EE", 3.0, 80);

        //create Professor instances
        Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 80000);
        Professor prof2 = new Professor("Frank", "Black", 801, "Math", 85000);
        
        // create a list to save students and professors
        ArrayList<Person> people = new ArrayList();
        // add students
        people.add(s1);
        people.add(s2);
        people.add(s3);
        people.add(s4);
        // add professors
        people.add(prof1);
        people.add(prof2);


        
        //Testing Unviversity implementation
        System.out.println("**** Testing University class implementation ****");
        // setup initial unviersity personnel
        uncc.setUp(people);
        // test getPersonnel method
        if (uncc.getPersonnel().size() == people.size()) {
            System.out.println("University setup works as expected");
        } else {
            System.out.println("Problem with university setup");
        }

        // try getStudents method
        if (uncc.getStudents().size() == 4) {
            System.out.println("University getStudents method works as expected");
        } else {
            System.out.println("Problem with getStudents method");
        }


        // try getProfessors method
        if (uncc.getProfessors().size() == 2) {
            System.out.println("University getProfessors method works as expected");
        } else {
            System.out.println("Problem with getProfessors method");
        }

        // try newStudent method
        Student s5 = new Student("Grace", "Maxeem", 903, "Psychology", 3.4, 95);
        uncc.newStudent(s5);
        if (uncc.getStudents().get(4).getId() == 903) {
            System.out.println("University getStudents method works as expected");
        } else {
            System.out.println("Problem with getStudents method");
        }

        // try newProfessor method
        Professor prof3 = new Professor("Maya", "Adams", 700, "Music", 95000);
        uncc.newProfessor(prof3);
        if (uncc.getProfessors().get(2).getId() == 700) {
            System.out.println("University getProfessors method works as expected");
        } else {
            System.out.println("Problem with getProfessors method");
        }
    }
}