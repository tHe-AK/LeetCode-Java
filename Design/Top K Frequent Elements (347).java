public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
    	Map<Integer, Integer> map = new HashMap<>();
        Set<Integer>[] buckets = new Set[len + 1];
    	
    	for (int i = 0; i <= len; i++) {
            buckets[i] = new HashSet<>();
    	}
    	
    	for (int num : nums) {
    	    int idx = map.getOrDefault(num, 0) + 1;
    	    buckets[idx].add(num);
    	    
    	    if (idx != 1) {
    	        buckets[idx - 1].remove(num);
    	    }
    	    
    	    map.put(num, idx);
    	}
    	
    	for (int i = len; i > 0; i--) {
            for (Integer num : buckets[i]) {
                result.add(num);
                k--;
    			
                if (k == 0) {
                    return result;
                }
            }
    	}
    	
    	return result;
    }
}
