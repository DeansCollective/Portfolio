import java.util.ArrayList;

public class University implements UniversitySpecification {

    private String name;
    private ArrayList<Person> personnel;

    public University(String name) {
        this.name = name;
        personnel = new ArrayList<>();
    }

    public ArrayList<Person> getPersonnel() {
        return personnel;
    }

    @Override
    public void setUp(ArrayList<Person> personnel) {
        this.personnel = personnel;
    }

    @Override
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Person p : personnel) {
            if (p instanceof Student) {
                students.add((Student)p);
            }
        }
        return students;
    }

    @Override
    public ArrayList<Professor> getProfessors() {
        ArrayList<Professor> professors = new ArrayList<>();
        for (Person p : personnel) {
            if (p instanceof Professor) {
                professors.add((Professor) p);
            }
        }
        return professors;
    }

    @Override
    public void newStudent(Student s) {
        personnel.add(s);
    }

    @Override
    public void newProfessor(Professor p) {
        personnel.add(p);
    }
}
