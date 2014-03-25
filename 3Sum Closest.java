public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int len = num.length;
        if (len < 3) {
            return target;
        }
        
        Arrays.sort(num);
        int max = num[0] + num[1] + num[2];
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum == target) {
                    return sum;
                }
                else if (sum < target) {
                    start++;
                }
                else {
                    end--;
                }
                
                if (Math.abs(target - sum) < Math.abs(target - max)) {
                    max = sum;
                }
            }
        }
        
        return max;
    }
}
