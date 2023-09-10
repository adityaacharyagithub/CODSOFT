import java.text.DecimalFormat;
import java.util.Scanner;

public class CSgradecalculator {
    static void startMethod(String user){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello "+user+" welcome to the Grade Calculator\n");

        System.out.print("Enter the number of subjects: ");
        int num_of_subjects = scanner.nextInt();

        if (num_of_subjects <= 0) {
            System.out.println("Invalid value of subjects (must be greater than 0)");
            scanner.close();
            return;
        }

        int total_Marks = 0;
        for (int i = 1; i <= num_of_subjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid value of marks (must be between 0 and 100)");
                scanner.close();
                return;
            }
            total_Marks += marks;
        }

        System.out.println("Total Marks Obtained: " + total_Marks);

        double avg_Percent = (double) total_Marks / (num_of_subjects * 100) * 100;

        DecimalFormat df = new DecimalFormat("0.00");
        String format_percentage = df.format(avg_Percent);

        System.out.println("Average Percentage: " + format_percentage + "%");

        String grade = calculateGrade(avg_Percent);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    static String calculateGrade(double avg_Percent) {
        if (avg_Percent > 95) {
            return "O";
        } else if (avg_Percent >= 90) {
            return "A+";
        } else if (avg_Percent >= 80) {
            return "A";
        } else if (avg_Percent >= 70) {
            return "B";
        } else if (avg_Percent >= 60) {
            return "C";
        } else if (avg_Percent >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        startMethod("codsoft");
    }
}
