public class PalindromeCheckerApp {

    // Function to check palindrome ignoring spaces and case
    public static boolean isPalindrome(String input) {

        // Normalize string: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        // Two-pointer comparison
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("=== Palindrome Checker App ===");

        String text = "Never Odd Or Even";

        if (isPalindrome(text)) {
            System.out.println("\"" + text + "\" is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("\"" + text + "\" is NOT a Palindrome.");
        }
    }
}