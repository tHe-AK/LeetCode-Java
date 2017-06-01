public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            String str = list2[j];
            
            if (map.containsKey(str)) {
                int sum = j + map.get(str);
                
                if (sum < min) {
                    res.clear();
                    res.add(str);
                    min = sum;
                } else if (sum == min) {
                    res.add(list2[j]);
                }
            }
        }
        
        return res.toArray(new String[0]);
    }
}
