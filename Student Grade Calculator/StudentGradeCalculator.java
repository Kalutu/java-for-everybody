import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        double sum = 0.0;

        System.out.println("\nStudent Grade Report:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.next();

            System.out.print("Enter the grade of student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();

            sum += grade; // Maintain a running sum

            System.out.println(name + ": " + grade);
        }

        double average = (numberOfStudents > 0) ? (sum / numberOfStudents) : 0.0;
        System.out.println("\nAverage Grade: " + average);
    }
}
