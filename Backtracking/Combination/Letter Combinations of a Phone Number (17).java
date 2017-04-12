public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<String>();
        }
        
        List<String> result = new LinkedList<String>();
        result.add("");
        String[] rec = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        
        for (int i = 0; i < digits.length(); i++) {
            String str = rec[Character.getNumericValue(digits.charAt(i))];
            int size = result.size();
            
            for (int j = 0; j < size; j++) {
                String peek = result.remove(0);
                
                for (int k = 0; k < str.length(); k++) {
                    result.add(peek + str.charAt(k));
                }
            }
        }
        
        return result;
    }
}

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        
        List<String> result = new ArrayList<String>();
        String[] rec = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        
        helper(digits, rec, 0, "", result);
        
        return result;
    }
    
    private void helper(String digits, String[] rec, int start, String curr, List<String> result) {
        if (start == digits.length()) {
            result.add(curr);
            return;
        }
        
        String str = rec[Character.getNumericValue(digits.charAt(start))];
        
        for (int i = 0; i < str.length(); i++) {
            helper(digits, rec, start + 1, curr + str.charAt(i), result);
        }
    }
}
