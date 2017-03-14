public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        
        int start = timeSeries[0];
        int end = timeSeries[0] + duration - 1;
        int result = 0;
        
        for (int i = 1; i < timeSeries.length; i++) {
            if (end < timeSeries[i]) {
                result += end - start + 1;
                start = timeSeries[i];
                end = timeSeries[i] + duration - 1;
            } else {
                end = Math.max(end, timeSeries[i] + duration - 1);
            }
        }
        
        result += end - start + 1;
        
        return result;
    }
}
