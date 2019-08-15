class Solution {
    public double[] sampleStats(int[] count) {
        int min = -1;
        int max = -1;
        int total = 0;
        double sum = 0;
        int mode = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                min = min < 0 ? i : min;
                max = i;
                total += count[i];
                sum += i * count[i];
                mode = count[mode] < count[i] ? i : mode;
            }
        }
        
        double mean = sum / total;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        total = 0;
        double median = 0;
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (total < left && left <= total + count[i]) {
                    median += i / 2.0;
                }
                
                if (total < right && right <= total + count[i]) {
                    median += i / 2.0;
                }
                
                total += count[i];
            }
        }
        
        return new double[] { min, max, mean, median, mode};
    }
}
