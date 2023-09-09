//File used to limit the percentage value to two decimal points
import java.text.DecimalFormat;
import java.util.Scanner;

public class CSgradecalculator {
    
    //Method 1 for user input for number of subjects and marks in each subjects
    static void startMethod(String user){
        //Scanner class for the user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello "+user+" welcome to the Grade Calculator\n");
        
        // Enter the number of subjects
        System.out.print("Enter the number of subjects: ");
        int num_of_subjects = scanner.nextInt();

        if (num_of_subjects <= 0) {
            //Prompt the user if the  input is invalid
            System.out.println("Invalid value of subjects (must be greater than 0)");
            scanner.close(); 
            return;
        }

        int total_Marks = 0;
        for (int i = 1; i <= num_of_subjects; i++) {
            //Enter the marks in the number of subject
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = scanner.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid value of marks (must be between 0 and 100)");
                scanner.close(); 
                return;
            }
            //Add the marks value of different subjects to a single variable(total_Marks)
            total_Marks += marks;
        }

        // Calculate total marks
        System.out.println("Total Marks Obtained: " + total_Marks);

        // Calculate average percentage
        double avg_Percent = (double) total_Marks / (num_of_subjects * 100) * 100;

        // Format the avg_Percent to two decimal places
        DecimalFormat df = new DecimalFormat("0.00");
        String format_percentage = df.format(avg_Percent);
        
        System.out.println("Average Percentage: " + format_percentage + "%");
        
        // Calculate the grade
        String grade = calculateGrade(avg_Percent);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
    //Method 2 for the calculation of grades
    static String calculateGrade(double avg_Percent) {
        if (avg_Percent >= 90) {
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
