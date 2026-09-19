import java.util.Scanner;

public class Q3 {

    // Returns the BMI category
    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Prints the wellness report
    public static void printWellnessReport(
            double[] heights, double[] weights) {

        System.out.println("\n============== WELLNESS REPORT ==============");

        System.out.printf(
                "%-10s %-12s %-13s %-10s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status"
        );

        System.out.println(
                "--------------------------------------------------------------"
        );

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf(
                    "%-10d %-12.2f %-13.2f %-10.2f %-15s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    status
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people: ");
        int numberOfPeople = scanner.nextInt();

        double[] heights = new double[numberOfPeople];
        double[] weights = new double[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {

            System.out.println("\nEnter details for Person " + (i + 1));

            do {
                System.out.print("Enter height in meters: ");
                heights[i] = scanner.nextDouble();

                if (heights[i] <= 0) {
                    System.out.println("Height must be greater than zero.");
                }
            } while (heights[i] <= 0);

            do {
                System.out.print("Enter weight in kilograms: ");
                weights[i] = scanner.nextDouble();

                if (weights[i] <= 0) {
                    System.out.println("Weight must be greater than zero.");
                }
            } while (weights[i] <= 0);
        }

        printWellnessReport(heights, weights);

        scanner.close();
    }
}