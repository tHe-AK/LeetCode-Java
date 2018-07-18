class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(i);
            } else {
                boolean expload = false;
                
                while (!stack.empty()) {
                    int peek = stack.peek();
                    
                    if (asteroids[peek] < 0) {
                        break;
                    } else if (asteroids[peek] > -asteroids[i]) {
                        expload = true;
                        break;
                    } else if (asteroids[peek] < -asteroids[i]) {
                        stack.pop();
                    } else {
                        expload = true;
                        stack.pop();
                        break;
                    }
                }
                
                if (!expload) {
                    stack.push(i);
                }
            }
        }
        
        int[] res = new int[stack.size()];
        int i = 0;
        
        for (int j : stack) {
            res[i++] = asteroids[j];
        }
        
        return res;
    }
}
