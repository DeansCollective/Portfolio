import java.util.*;

public class Main {
    
public static void showProfile(Person p, int id) {
    if (p.getId() == id) {
        p.display();
    }
}

    public static void main(String[] args) {    
    ArrayList<Person> contactList = new ArrayList<>();
    
    // System.out.println("**** Part A ****");
    // Person p = new Person("Raya", "Whitker", 800555555);
    // p.display();
    // System.out.println("**** Part B ****");
    
    Student s1 = new Student ("Xavier",  "Cato", 900111222, "CS", 3.5, 75);
    s1.setTransfer(true);
    s1.setBalance (100);
    s1.addCourse("Java Programming");
    s1.addCourse("Calculus");
    s1.display();

    System.out.println();
    // if (s1.dropCourse("Spanish")) {
    //     System.out.println("The class has been dropped");
    // } else {
    //     System.out.println("You are not enrolled in this course. " + "No courses have been dropped.");
    //     ArrayList<String> enrolledCourses = s1.getEnrolledCourses();
    //     System.out.println("You are enrolled in the following courses: ");
    //     for (String course: enrolledCourses) {
    //         System.out.println(course);
    //     }
    // }
    //    System.out.println("**** Part C ****");
        Student s2 = new Student("Kathrine", "Johnson", 900, "CS", 4.0, 100);
        Student s3 = new Student("Roy", "Clay", 901, "Biology", 3.2, 85);
        Student s4 = new Student("Kimberly", "Bryant", 902, "EE", 3.0, 88);
        Professor prof1 = new Professor("Mary", "Castro", 300, "CS", 80000);
        
        prof1.addAdvisee(s2);
        prof1.addAdvisee(s3);
        prof1.addAdvisee(s4);
        prof1.display();
                
        // if (prof1.removeAdvisee(902)) {
        //     System.out.println("The advisee has been removed");
        // } else {
        //     System.out.println("This student is not an advisee of Professor " + prof1.getFirstName() + " " + prof1.getLastName());
        // }
        // ArrayList<Student> myAdvisees = prof1.getAdvisees();
        // System.out.println("Professor " + prof1.getFirstName() + " " + prof1.getLastName() + " advisees:");
        // for (Student s : myAdvisees) {
        //     System.out.println(s.getFirstName() + " " + s.getLastName());
        // }
        contactList.add(s1);
        contactList.add(s2);
        contactList.add(s3);
        contactList.add(s4);
        contactList.add(prof1);
        
        Person p2 = new Person("Elle", "Kambol", 800);
        contactList.add(p2);

        Professor prof2 = new Professor("Frank", "Black", 801, "Math", 85000);
        contactList.add(prof2);

        Student s5 = new Student("Grace", "Maxeen", 903, "Psychology", 3.4, 95);
        contactList.add(s5);
        
        for (Person p : contactList) {
            p.display();
            System.out.println();
        }
        
        System.out.println("Part B");
        for (Person person : contactList) {
            showProfile(person, 903);
        }
        System.out.println();
        System.out.println("part 3");
        Person p3 = new Student("Maya", "Adams", 700, "Music",3.5, 105 );
        System.out.println(((Student)p3).getGPA());
//        Person p4 = new Person("Bob", "Lowe",701);
//        if (p4 instanceof Student){
//            System.out.println(((Student)p4).getGPA());
//        }
        
        double minGPA = 3.5;
        System.out.println("Students eligible for scholarship:");
        for (int i = 0; i < contactList.size(); i++) {
            Person honors = contactList.get(i);
            if (honors instanceof Student) {
                Student s = (Student) honors;
                if (s.getGPA() > minGPA) {
                    System.out.println(s.getFirstName() + " " + s.getLastName());
                }
            }
        }
        
        String job = "CS";
        System.out.println("Professors in CS:");
        for (int i = 0; i < contactList.size(); i++) {
            Person professor = contactList.get(i);
            if (professor instanceof Professor) {
                Professor prof = (Professor) professor;
                if (prof.getDepartment().equals(job)) {
                    System.out.println(prof.getFirstName() + " " + prof.getLastName());
                }
            }
        }
        System.out.println();


        Student s0 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        System.out.println(s0);

        Professor prof0 = new Professor("Mary", "Castro", 300, "CS", 80000);
        System.out.println(prof0);

        System.out.println(s0.equals(s4)); 
        Student s10 = new Student("Xavier", "Cato", 900111222, "CS", 3.5, 75);
        System.out.println(s0.equals(s10)); 
        System.out.println(s0.equals(prof0)); 

        Person[] personArray = {s1, s2, prof1}; 
        ArrayList<Person> personList = new ArrayList(); 
        personList.add(s1); 
        personList.add(s2); 
        personList.add(prof1); 
        System.out.println("\nContent of personList:"); 
        for (Person person: personList) { 
            System.out.println(person);
        }
        
    }
}

   

    
    


