class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int direction = 0;
        int i = 0;
        int j = 0;
        int max = 0;
        int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Set<String> set = new HashSet<>();
        
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }
        
        for (int command : commands) {
            if (command == -2) {
                direction = (direction - 1 + 4) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int k = 0; k < command; k++) {
                    int x = i + delta[direction][0];
                    int y = j + delta[direction][1];
                    
                    if (set.contains(x + " " + y)) {
                        break;
                    }
                    
                    i = x;
                    j = y;
                    max = Math.max(max, i * i + j * j);
                }
            }
        }
        
        return max;
    }
}
