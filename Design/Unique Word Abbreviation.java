public class ValidWordAbbr {
    private Map<String, Set<String>> rec;
    
    public ValidWordAbbr(String[] dictionary) {
        if (dictionary == null) {
            throw new IllegalArgumentException();
        }
        
        rec = new HashMap<String, Set<String>>();
        
        for (String str : dictionary) {
            String abbr = getAbbreviation(str);
            
            if (rec.containsKey(abbr)) {
                rec.get(abbr).add(str);
            } else {
                Set<String> val = new HashSet<String>();
                val.add(str);
                rec.put(abbr, val);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        
        if (!rec.containsKey(abbr) || (rec.get(abbr).contains(word) && rec.get(abbr).size() == 1)) {
            return true;
        } else {
            return false;
        }
    }
    
    private String getAbbreviation(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        
        int len = str.length();
        return len > 2 ? str.substring(0, 1) + (len - 2) + str.substring(len - 1, len) : str;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
