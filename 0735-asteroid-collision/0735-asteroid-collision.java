import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean exploded = false;
            
            // Collision happens only when stack top is moving RIGHT (+) and current is moving LEFT (-)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (Math.abs(stack.peek()) < Math.abs(ast)) {
                    stack.pop(); // The right-moving asteroid is smaller and explodes
                    continue;    // Check the next asteroid on the stack
                } else if (Math.abs(stack.peek()) == Math.abs(ast)) {
                    stack.pop(); // Both are the same size, both explode
                    exploded = true;
                    break;
                } else {
                    exploded = true; // Current left-moving asteroid is smaller and explodes
                    break;
                }
            }
            
            // If the current asteroid did not explode, push it to the stack
            if (!exploded) {
                stack.push(ast);
            }
        }
        
        // Convert the stack back to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
