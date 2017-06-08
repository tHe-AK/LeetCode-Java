public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String path: paths) {
            String[] values = path.split(" ");
            
            for (int i = 1; i < values.length; i++) {
                String[] strs = values[i].split("\\(");
                strs[1] = strs[1].substring(0, strs[1].length() - 1);
                List<String> list = map.getOrDefault(strs[1], new ArrayList<>());
                list.add(values[0] + "/" + strs[0]);
                map.put(strs[1], list);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for (String key: map.keySet()) {
            List<String> val = map.get(key);
            
            if (val.size() > 1) {
                res.add(val);
            }
        }
        
        return res;
    }
}
