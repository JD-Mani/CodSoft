import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t\t Student Grade Calculator \n");

        // Input: Take marks obtained in each subject
        System.out.println("Enter the marks in each subject (out of 100):");
        System.out.print("Subject 1: ");
        int subject1 = scanner.nextInt();
        System.out.print("Subject 2: ");
        int subject2 = scanner.nextInt();
        System.out.print("Subject 3: ");
        int subject3 = scanner.nextInt();
        System.out.print("Subject 4: ");
        int subject4 = scanner.nextInt();
        System.out.print("Subject 5: ");
        int subject5 = scanner.nextInt();

        // Calculate Total Marks
        int totalMarks = calculateTotalMarks(subject1, subject2, subject3, subject4, subject5);

        // Calculate Average Percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, 5);

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);

        // Display Results
        displayResults(totalMarks, averagePercentage, grade);
    }

    private static int calculateTotalMarks(int subject1, int subject2, int subject3, int subject4, int subject5) {
        return subject1 + subject2 + subject3 + subject4 + subject5;
    }

    private static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}

