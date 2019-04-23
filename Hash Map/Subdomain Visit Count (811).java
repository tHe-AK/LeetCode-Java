class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for (String cpdomain : cpdomains) {
            String[] pair = cpdomain.split("\\s+");
            String[] domains = pair[1].split("\\.");
            int count = Integer.parseInt(pair[0]);
            String str = "";
            
            for (int i = domains.length - 1; i >= 0; i--) {
                str = domains[i] + (str.isEmpty() ? "" : ".") + str;
                int val = map.getOrDefault(str, 0);
                map.put(str, val + count);
            }
        }
        
        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }
        
        return res;
    }
}
