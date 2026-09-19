import java.util.Random;
import java.util.Scanner;

public class Q1 {

    // Determines the winner of one round
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 5;

        String[] choices = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Rock-Paper-Scissors Game ===");

        for (int i = 0; i < totalRounds; i++) {

            System.out.println("\nRound " + (i + 1));

            // Accept and validate the player's move
            while (true) {
                System.out.print("Enter Rock, Paper, or Scissors: ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("Rock") ||
                    input.equalsIgnoreCase("Paper") ||
                    input.equalsIgnoreCase("Scissors")) {

                    playerMoves[i] =
                        input.substring(0, 1).toUpperCase()
                        + input.substring(1).toLowerCase();

                    break;
                }

                System.out.println("Invalid input. Please try again.");
            }

            // Generate the computer's move randomly
            int randomNumber = random.nextInt(3);
            computerMoves[i] = choices[randomNumber];

            // Determine the result
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer Move: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);
        }

        // Print the final summary
        System.out.println("\n================ FINAL SUMMARY ================");

        System.out.printf(
            "%-8s %-15s %-17s %-15s%n",
            "Round", "Player Move", "Computer Move", "Result"
        );

        System.out.println(
            "---------------------------------------------------------"
        );

        for (int i = 0; i < totalRounds; i++) {
            System.out.printf(
                "%-8d %-15s %-17s %-15s%n",
                i + 1,
                playerMoves[i],
                computerMoves[i],
                results[i]
            );
        }

        double winPercentage = ((double) wins / totalRounds) * 100;

        System.out.println("\nWins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        scanner.close();
    }
}