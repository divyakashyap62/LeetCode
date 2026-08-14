import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        // Use ArrayDeque as it is faster than the legacy Stack class
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push the expected closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, check if it matches the top of the stack
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // If the stack is empty, all brackets were correctly matched
        return stack.isEmpty();
    }
}
