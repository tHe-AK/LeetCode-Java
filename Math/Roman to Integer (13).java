public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> rec = new HashMap<Character, Integer>();
        rec.put('I', 1);
        rec.put('V', 5);
        rec.put('X', 10);
        rec.put('L', 50);
        rec.put('C', 100);
        rec.put('D', 500);
        rec.put('M', 1000);
        
        int sum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && rec.get(s.charAt(i)) < rec.get(s.charAt(i + 1))) {
                sum -= rec.get(s.charAt(i));
            }
            else {
                sum += rec.get(s.charAt(i));
            }
        }
        
        return sum;
    }
}
