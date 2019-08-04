class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] delta = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        int idx = 0;
        int i = 0;
        int j = 0;
        
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                i += delta[idx][0];
                j += delta[idx][1];
            } else if (ch == 'L') {
                idx = (idx + 1) % 4;
            } else {
                idx = (idx + 3) % 4;
            }
        }
        
        return (i == 0 && j == 0) || idx > 0;
    }
}
