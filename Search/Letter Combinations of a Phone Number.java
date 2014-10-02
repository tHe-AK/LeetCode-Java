public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            throw new IllegalArgumentException();
        }
        
        List<String> result = new ArrayList<String>();
        result.add("");
        HashMap<Character, String> rec = new HashMap<Character, String>();
        rec.put('1', "");
        rec.put('2', "abc");
        rec.put('3', "def");
        rec.put('4', "ghi");
        rec.put('5', "jkl");
        rec.put('6', "mno");
        rec.put('7', "pqrs");
        rec.put('8', "tuv");
        rec.put('9', "wxyz");
        rec.put('0', " ");
        
        for (int i = 0; i < digits.length(); i++) {
            List<String> next = new ArrayList<String>();
            
            for (int j = 0; j < result.size(); j++) {
                String val = rec.get(digits.charAt(i));
                
                for (int k = 0; k < val.length(); k++) {
                    next.add(result.get(j) + val.charAt(k));
                }
            }
            
            result = next;
        }
        
        return result;
    }
}

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            throw new IllegalArgumentException();
        }
        
        List<String> result = new ArrayList<String>();
        HashMap<Character, String> rec = new HashMap<Character, String>();
        rec.put('1', "");
        rec.put('2', "abc");
        rec.put('3', "def");
        rec.put('4', "ghi");
        rec.put('5', "jkl");
        rec.put('6', "mno");
        rec.put('7', "pqrs");
        rec.put('8', "tuv");
        rec.put('9', "wxyz");
        rec.put('0', " ");
        
        helper(digits, rec, 0, "", result);
        
        return result;
    }
    
    private void helper(String digits, HashMap<Character, String> rec, int start, String cur, List<String> result) {
        if (start == digits.length()) {
            result.add(cur);
            return;
        }
        
        String value = rec.get(digits.charAt(start));
        
        for (int i = 0; i < value.length(); i++) {
            helper(digits, rec, start + 1, cur + value.charAt(i), result);
        }
    }
}