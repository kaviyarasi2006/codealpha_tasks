import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("     Student Grade Tracker");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Summary Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    summaryReport();
                    break;
                case 4:
                    System.out.println("Thank you! Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }

    static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.next();

        System.out.print("Enter marks (0-100): ");
        int grade = sc.nextInt();

        names.add(name);
        grades.add(grade);

        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (names.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n------ Student List ------");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + grades.get(i) + 
            " (" + getGradeLetter(grades.get(i)) + ")");
        }
    }

    static void summaryReport() {
        if (grades.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        int highest = grades.get(0);
        int lowest = grades.get(0);
        int sum = 0;

        for (int g : grades) {
            sum += g;
            if (g > highest)
                highest = g;
            if (g < lowest)
                lowest = g;
        }

        double average = (double) sum / grades.size();

        System.out.println("\n====== Summary Report ======");
        System.out.println("Total Students : " + grades.size());
        System.out.println("Average Score  : " + average);
        System.out.println("Highest Score  : " + highest);
        System.out.println("Lowest Score   : " + lowest);
    }

    static String getGradeLetter(int grade) {
        if (grade >= 90)
            return "A";
        else if (grade >= 80)
            return "B";
        else if (grade >= 70)
            return "C";
        else if (grade >= 60)
            return "D";
        else
            return "Fail";
    }
}
