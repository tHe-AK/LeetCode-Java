public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> CntMap = new HashMap<>();
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            if (freqMap.get(num) > 0) {
                freqMap.put(num, freqMap.get(num) - 1);
                
                if (CntMap.getOrDefault(num - 1, 0) > 0) {
                    CntMap.put(num - 1, CntMap.get(num - 1) - 1);
                    CntMap.put(num, CntMap.getOrDefault(num, 0) + 1);
                } else if (freqMap.getOrDefault(num + 1, 0) > 0 && freqMap.getOrDefault(num + 2, 0) > 0) {
                    freqMap.put(num + 1, freqMap.get(num + 1) - 1);
                    freqMap.put(num + 2, freqMap.get(num + 2) - 1);
                    CntMap.put(num + 2, CntMap.getOrDefault(num + 2, 0) + 1);
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}

public class Solution {
    public boolean isPossible(int[] nums) {
        int count = 0;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        
        for (int num : nums) {
            int len = 1;
            
            if (map.containsKey(num - 1)) {
                Queue<Integer> queue = map.get(num - 1);
                len += queue.poll();
                
                if (len == 3) {
                    count--;
                }
                
                if (queue.isEmpty()) {
                    map.remove(num - 1);
                }
            } else {
                count++;
            }
            
            map.putIfAbsent(num, new PriorityQueue<>());
            map.get(num).add(len);
        }
        
        return count == 0;
    }
}
