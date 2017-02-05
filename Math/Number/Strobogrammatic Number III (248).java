public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, Arrays.asList(""));
        map.put(1, Arrays.asList("0", "1", "8"));
        int left = low.length();
        int right = high.length();
        int count = 0;
        
        for (int i = left; i <= right; i++) {
            List<String> list = findStrobogrammatic(i, map);

            for (String str : list) {
                if ((i <= 1 || str.charAt(0) != '0') && (i > left || str.compareTo(low) >= 0) && (i < right || str.compareTo(high) <= 0)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private List<String> findStrobogrammatic(int n, Map<Integer, List<String>> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        
        List<String> result = new ArrayList<String>();
        
        if (n == 0) {
            result = Arrays.asList("");
        } else if (n == 1) {
            result = Arrays.asList("0", "1", "8");
        } else {
            List<String> list = findStrobogrammatic(n - 2, map);

            for (String str : list) {
                result.add("0" + str + "0");
                result.add("1" + str + "1");
                result.add("8" + str + "8");
                result.add("6" + str + "9");
                result.add("9" + str + "6");
            }
        }
        
        map.put(n, result);
        
        return result;
    }
}
