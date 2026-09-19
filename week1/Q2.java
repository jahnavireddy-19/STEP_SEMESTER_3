import java.util.Scanner;

public class Q2 {

    // Approach 1: Iterative method
    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive method
    public static boolean isPalindromeRecursive(String text) {
        return checkRecursive(text, 0, text.length() - 1);
    }

    public static boolean checkRecursive(
            String text, int left, int right) {

        // Base condition
        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return checkRecursive(text, left + 1, right - 1);
    }

    // Approach 3: Array reversal method
    public static boolean isPalindromeArrayReversal(String text) {

        char[] characters = text.toCharArray();
        char[] reversed = new char[characters.length];

        for (int i = 0; i < characters.length; i++) {
            reversed[i] = characters[characters.length - 1 - i];
        }

        String reversedText = new String(reversed);

        return text.equals(reversedText);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine();

        // Remove spaces and punctuation and convert to lowercase
        String cleanedText =
                text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean iterativeResult =
                isPalindromeIterative(cleanedText);

        boolean recursiveResult =
                isPalindromeRecursive(cleanedText);

        boolean arrayResult =
                isPalindromeArrayReversal(cleanedText);

        System.out.println(
                "Iterative: "
                + (iterativeResult ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Recursive: "
                + (recursiveResult ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Array Reversal: "
                + (arrayResult ? "Palindrome" : "Not Palindrome")
        );

        scanner.close();
    }
}