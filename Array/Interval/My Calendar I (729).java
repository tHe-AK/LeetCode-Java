class MyCalendar {
    private TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floor = map.floorKey(start);
        Integer ceiling = map.ceilingKey(start);
        
        if ((floor == null || map.get(floor) <= start) && (ceiling == null || end <= ceiling)) {
            map.put(start, end);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
