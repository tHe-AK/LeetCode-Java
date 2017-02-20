public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> intersect = new ArrayList<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    
        for (int num : nums2) {
            if (map.containsKey(num)) {
                intersect.add(num);
                int count = map.get(num);
                
                if (count > 1) {
                    map.put(num, count - 1);
                } else {
                    map.remove(num);
                }
            }
        }
    
        int[] result = new int[intersect.size()];
       
        for (int i = 0; i < result.length; i++) {
            result[i] = intersect.get(i);
        }
    
        return result;
    }
}

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
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
            }
        }
    
        int[] result = new int[intersect.size()];
       
        for (i = 0; i < result.length; i++) {
            result[i] = intersect.get(i);
        }
    
        return result;
    }
}
