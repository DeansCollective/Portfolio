import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("inputData.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
            throw new RuntimeException(e);
        }

        ArrayList<Student> students = new ArrayList<Student>();

        String line = fileScanner.nextLine();
        while (fileScanner.hasNext()) {
            try {
                String[] info = line.split(",");
                if (info[0].equals("student")) {
                    students.add(new Student(info[1], info[2], Integer.valueOf(info[3]), info[4], Double.valueOf(info[5]), Integer.valueOf(info[6])));
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR");
            }
            line = fileScanner.nextLine();
        }

        fileScanner.close();

        Collections.sort(students);

        FileOutputStream fs = null;
        PrintWriter outFS = null;
        try {
            fs = new FileOutputStream("ScholarshipCandididates.txt");
            outFS = new PrintWriter(fs);
        } catch (FileNotFoundException e) {
            System.out.println("No output file.");
            throw new RuntimeException(e);
        }

        outFS.println("Top candidates: ");
        for (Student x : students) {
            if (x.getGPA() >= 3.5) {
                outFS.println(x.getGPA() + ", " + x.getName() + ", " + x.getMajor());
            }
        }
        outFS.println();

        outFS.println("Middle candidates: ");
        for (Student x : students) {
            if (x.getGPA() >= 3.2 && x.getGPA() < 3.5) {
                outFS.println(x.getGPA() + ", " + x.getName() + ", " + x.getMajor());
            }
        }
        outFS.println();

        outFS.println("Low candidates: ");
        for (Student x : students) {
            if (x.getGPA() < 3.2) {
                outFS.println(x.getGPA() + ", " + x.getName() + ", " + x.getMajor());
            }
        }

        outFS.close();
        try {
            fs.close();
        } catch (IOException e) {
            System.out.println("No output file.");
            throw new RuntimeException(e);
        }
    }
}
