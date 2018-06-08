class RangeModule {
    private TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer key1 = map.floorKey(left);
        Integer key2 = map.floorKey(right);

        if (key1 != null && left <= map.get(key1)) {
            left = key1;
        }
        
        if (key2 != null && right < map.get(key2)) {
            right = map.get(key2);
        }
        
        Set<Integer> set = map.subMap(left, right).keySet();
        map.keySet().removeAll(new HashSet<Integer>(set));
        map.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        return start != null && right <= map.get(start);
    }
    
    public void removeRange(int left, int right) {
        Integer key1 = map.floorKey(left);
        Integer key2 = map.floorKey(right);

        if (key2 != null && right < map.get(key2)) {
            map.put(right, map.get(key2));
        }
        
        if (key1 != null && left < map.get(key1)) {
            map.put(key1, left);
        }
        
        Set<Integer> set = map.subMap(left, right).keySet();
        map.keySet().removeAll(new HashSet<Integer>(set));
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
