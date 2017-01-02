public class Solution {
    public int threeSumClosest(int[] num, int target) {      
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];
        
        for (int i = 0; i < num.length - 2; i++) {
            int low = i + 1;
            int high = num.length - 1;
            
            while (low < high) {
                int sum = num[i] + num[low] + num[high];
                
                if (sum == target) {
                    return sum;
                }
                else if (sum < target) {
                    low++;
                }
                else {
                    high--;
                }
                
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }
        }
        
        return result;
    }
}
