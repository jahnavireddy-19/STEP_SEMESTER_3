import java.util.HashMap;
import java.util.Scanner;

public class Q4 {

    public static char findFirstNonRepeatingChar(String text) {

        HashMap<Character, Integer> frequency = new HashMap<>();

        // Count the frequency of every character
        for (int i = 0; i < text.length(); i++) {

            char character = text.charAt(i);

            // Ignore spaces
            if (character != ' ') {
                frequency.put(
                        character,
                        frequency.getOrDefault(character, 0) + 1
                );
            }
        }

        // Find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {

            char character = text.charAt(i);

            if (character != ' ' && frequency.get(character) == 1) {
                return character;
            }
        }

        // Null character means no result was found
        return '\0';
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine().toLowerCase();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println(
                    "No Non-Repeating Character Found"
            );
        } else {
            System.out.println(
                    "First Non-Repeating Character: '" + result + "'"
            );
        }

        scanner.close();
    }
}