public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
    	Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[len + 1];

    	for (int num : nums) {
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	for (int i = 0; i <= len; i++) {
    	    bucket[i] = new ArrayList<>();
    	}
    
    	for (int key : map.keySet()) {
    		bucket[map.get(key)].add(key);
    	}
    
    	for (int i = len; i >= 0; i--) {
    		for (Integer num : bucket[i]) {
    		    if (k > 0) {
    			    result.add(num);
    			    
    			    if (--k == 0) {
    			        break;
    			    }
    		    }
    		}
    	}
    	
    	return result;
    }
}
