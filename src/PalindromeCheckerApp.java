import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String word);
}

// Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    public boolean check(String word) {
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
}

// Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String word) {
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
}

// Context Class
class PalindromeChecker {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String word) {
        return strategy.check(word);
    }
}

// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("=== Palindrome Checker App ===");

        String word = "level";

        PalindromeChecker checker = new PalindromeChecker();

        // Inject Stack strategy
        checker.setStrategy(new StackStrategy());

        if (checker.checkPalindrome(word)) {
            System.out.println("Using Stack Strategy: Palindrome");
        } else {
            System.out.println("Using Stack Strategy: Not Palindrome");
        }

        // Inject Deque strategy
        checker.setStrategy(new DequeStrategy());

        if (checker.checkPalindrome(word)) {
            System.out.println("Using Deque Strategy: Palindrome");
        } else {
            System.out.println("Using Deque Strategy: Not Palindrome");
        }
    }
}