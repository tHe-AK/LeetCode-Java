public class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> map;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int idx = nums.size();
        nums.add(val);
        
        if (map.containsKey(val)) {
            map.get(val).add(idx);
            return false;
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(idx);
            map.put(val, set);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Set<Integer> set = map.get(val);
            int idx = set.iterator().next();
            set.remove(idx);
            int lastIdx = nums.size() - 1;
            
            if (idx != lastIdx) {
                int num = nums.get(lastIdx);
                map.get(num).add(idx);
                map.get(num).remove(lastIdx);
                nums.set(idx, num);
            }
            
            if (set.isEmpty()) {
                map.remove(val);
            }
            
            nums.remove(lastIdx);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
