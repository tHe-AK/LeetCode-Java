class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                boolean expload = false;
                
                while (!stack.empty()) {
                    int peek = stack.peek();
                    
                    if (peek < 0) {
                        break;
                    } else if (peek > -asteroid) {
                        expload = true;
                        break;
                    } else if (peek < -asteroid) {
                        stack.pop();
                    } else {
                        expload = true;
                        stack.pop();
                        break;
                    }
                }
                
                if (!expload) {
                    stack.push(asteroid);
                }
            }
        }
        
        int[] res = new int[stack.size()];
        
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        
        return res;
    }
}
