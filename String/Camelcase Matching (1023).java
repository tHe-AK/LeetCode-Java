class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        
        for (String query : queries) {
            res.add(isValid(query, pattern));
        }
        
        return res;
    }
    
    private boolean isValid(String query, String pattern) {
        int i = 0;
        int j = 0;
        
        while (i < query.length() || j < pattern.length()) {
            if (i < query.length() && j < pattern.length() && query.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (i < query.length() && Character.isLowerCase(query.charAt(i))) {
                i++;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
