public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }
        
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
        
        List<String> result = new ArrayList<String>();
        helper(digits, 0, rec, "", result);
        
        return result;
    }
    
    private void helper(String digits, int index, HashMap<Character, String> rec, String cur, List<String> result) {
        if (index == digits.length()) {
            result.add(cur.toString());
            return;
        }
        
        String value = rec.get(digits.charAt(index));
        for (int i = 0; i < value.length(); i++) {
            helper(digits, index + 1, rec, cur + value.charAt(i), result);
        }
    }
}
