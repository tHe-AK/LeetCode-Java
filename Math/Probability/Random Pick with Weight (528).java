class Solution {
    private TreeMap<Integer, Integer> treeMap;
    private int sum;
    private Random rand;
    
    public Solution(int[] w) {
        treeMap = new TreeMap<>();
        sum = 0;
        rand = new Random();
        
        for (int i = 0; i < w.length; i++) {
            treeMap.put(sum, i);
            sum += w[i];
        }
    }
    
    public int pickIndex() {
        int num = rand.nextInt(sum);
        int key = treeMap.floorKey(num);
        return treeMap.get(key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

class Solution {
    private int[] nums;
    private int sum;
    private Random rand;
    
    public Solution(int[] w) {
        nums = new int[w.length];
        sum = 0;
        rand = new Random();
        
        for (int i = 0; i < w.length; i++) {
            nums[i] = sum;
            sum += w[i];
        }
    }
    
    public int pickIndex() {
        int target = rand.nextInt(sum);
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return high;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
