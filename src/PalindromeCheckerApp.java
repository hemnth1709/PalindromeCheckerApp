import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    // Stack Method
    public static boolean stackPalindrome(String word) {
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        for (char c : word.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Deque Method
    public static boolean dequePalindrome(String word) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    // Two Pointer Method
    public static boolean twoPointerPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("=== Palindrome Algorithm Performance Comparison ===");

        String word = "racecar";

        // Stack Algorithm Timing
        long start1 = System.nanoTime();
        boolean stackResult = stackPalindrome(word);
        long end1 = System.nanoTime();

        // Deque Algorithm Timing
        long start2 = System.nanoTime();
        boolean dequeResult = dequePalindrome(word);
        long end2 = System.nanoTime();

        // Two Pointer Algorithm Timing
        long start3 = System.nanoTime();
        boolean pointerResult = twoPointerPalindrome(word);
        long end3 = System.nanoTime();

        // Display Results
        System.out.println("Stack Result: " + stackResult +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Deque Result: " + dequeResult +
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Two Pointer Result: " + pointerResult +
                " | Time: " + (end3 - start3) + " ns");
    }
}