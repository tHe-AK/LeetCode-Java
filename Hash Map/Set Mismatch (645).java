public class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = 0;
        int missing = 0;
        
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            
            if (nums[idx] < 0) {
                dup = idx + 1;
            } else {
                nums[idx] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        
        return new int[] { dup, missing };
    }
}

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] map = new int[nums.length + 1];
        int dup = 0;
        int missing = 0;
        
        for (int num : nums) {
            map[num] += 1;
        }
        
        for (int i = 1; i < map.length; i++) {
            if (map[i] == 0) {
                missing = i;
            } else if (map[i] == 2) {
                dup = i;
            }
        }
        
        return new int[] { dup, missing };
    }
}

public class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dup = 0;
        long sum = (1 + nums.length) * nums.length / 2;
        
        for (int num : nums) {
            if (!set.add(num)) {
                dup = num;
            } else {
                sum -= num;
            }
        }
        
        return new int[] { dup, (int) sum };
    }
}
