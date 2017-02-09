public class ValidWordAbbr {
    private Map<String, String> map;
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        
        for (String word : dictionary) {
            String abbr = getAbbreviation(word);
            
            if (map.containsKey(abbr)) {
                if (!word.equals(map.get(abbr))) {
                    map.put(abbr, null);
                }
            } else {
                map.put(abbr, word);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        
        return !map.containsKey(abbr) || word.equals(map.get(abbr));
    }
    
    private String getAbbreviation(String word) {
        int len = word.length();
        return len > 2 ? word.charAt(0) + Integer.toString(len - 2) + word.charAt(len - 1) : word;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
