class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        int prevMax = 0;
        int currMax = 0;
        
        for (int num : nums) {
            count[num]++;
        }
        
        for (int i = 1; i <= 10000; i++) {
            if (count[i] > 0) {
                if (count[i - 1] > 0) {
                    int temp = Math.max(currMax, prevMax + i * count[i]);
                    prevMax = currMax;
                    currMax = temp;
                } else {
                    prevMax = currMax;
                    currMax += i * count[i];
                }
            }
        }
        
        return currMax;
    }
}
