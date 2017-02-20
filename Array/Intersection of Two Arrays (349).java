public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        for (int num : nums1) {
            set.add(num);
        }
        
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }
        
        int[] result = new int[intersect.size()];
        int i = 0;
        
        for (Integer num : intersect) {
            result[i++] = num;
        }
        
        return result;
    }
}

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersect = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersect.add(nums1[i]);
                i++;
                j++;
                
                while (i < nums1.length && nums1[i] == nums1[i - 1]) {
                    i++;
                }
                
                while (j < nums2.length && nums2[j] == nums2[j - 1]) {
                    j++;
                }
            }
        }
    
        int[] result = new int[intersect.size()];
       
        for (i = 0; i < result.length; i++) {
            result[i] = intersect.get(i);
        }
    
        return result;
    }
}
