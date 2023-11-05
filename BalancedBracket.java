package DSA_GradedProject4;
import java.util.*;

public class BalancedBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        if (isBalanced(str)) {
            System.out.println("The entered string has balanced brackets.");
        } else {
            System.out.println("The entered string has unbalanced brackets.");
        }
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}