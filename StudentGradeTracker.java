import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentGrades = new ArrayList<>();

        System.out.println("Welcome to the Student Grade Tracker");
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter grade of " + name + ": ");
            int grade = scanner.nextInt();
            scanner.nextLine(); 
            studentNames.add(name);
            studentGrades.add(grade);
        }
        displayReport(studentNames, studentGrades);
        scanner.close();
    }

    public static void displayReport(ArrayList<String> names, ArrayList<Integer> grades) {
        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        System.out.println("\n--- Student Grades Report ---");

        for (int i = 0; i < names.size(); i++) {
            int grade = grades.get(i);
            total += grade;
            if (grade > highest) {
                highest = grade;
                topStudent = names.get(i);
            }
            if (grade < lowest) {
                lowest = grade;
                lowStudent = names.get(i);
            }

            System.out.println(names.get(i) + " - " + grade);
        }

        double average = (double) total / grades.size();

        System.out.println("\nAverage Grade: " + average);
        System.out.println("Highest Grade: " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Grade: " + lowest + " (" + lowStudent + ")");
    }
}
