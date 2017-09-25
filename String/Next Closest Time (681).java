class Solution {
    public String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();
        set.add(time.charAt(0));
        set.add(time.charAt(1));
        set.add(time.charAt(3));
        set.add(time.charAt(4));
        
        int num = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
        int i = (num + 1) % 1440;
        
        while (i != num) {
            String str = String.format("%02d", i / 60) + ":" + String.format("%02d", i % 60);
            
            if (set.contains(str.charAt(0)) && set.contains(str.charAt(1)) && set.contains(str.charAt(3)) && set.contains(str.charAt(4))) {
                return str;
            }
                
            i = (i + 1) % 1440;
        }
        
        return time;
    }
}
