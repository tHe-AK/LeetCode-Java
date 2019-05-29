class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int start = 0;
        int count = 0;
        
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                count++;
                max = Math.max(max, start == 0 ? count : (count + 1) / 2);
            } else {
                count = 0;
                start = i + 1;
            }
        }
        
        if (count > 0) {
            max = Math.max(max, count);
        }
        
        return max;
    }
}
