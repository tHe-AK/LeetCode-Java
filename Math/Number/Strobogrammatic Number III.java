public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        if (low == null || high == null) {
            throw new IllegalArgumentException();
        }
    
        Map<Integer, List<String>> rec = new HashMap<Integer, List<String>>();
        rec.put(0, new ArrayList<String>(Arrays.asList("")));
        rec.put(1, new ArrayList<String>(Arrays.asList("0", "1", "8")));
        int left = low.length();
        int right = high.length();
        int count = 0;
        
        for (int i = left; i <= right; i++) {
            List<String> cur = helper(i, rec);
            count += cur.size();
            
            for (String str : cur) {
                if ((i > 1 && str.charAt(0) == '0') || (i == left && str.compareTo(low) < 0) || (i == right && str.compareTo(high) > 0)) {
                count--;
                }
            }
        }
        
        return count;
    }
    
    private List<String> helper(int i, Map<Integer, List<String>> rec) {
        if (rec.containsKey(i)) {
            return rec.get(i);
        }
        
        List<String> result = new ArrayList<String>();
        List<String> pre = helper(i - 2, rec);
        
        for (String str : pre) {
            result.add("0" + str + "0");
            result.add("1" + str + "1");
            result.add("8" + str + "8");
            result.add("6" + str + "9");
            result.add("9" + str + "6");
        }
            
        rec.put(i, result);
        return result;
    }
}
