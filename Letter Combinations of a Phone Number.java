public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        if (digits == null) {
            return new ArrayList<String>();
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
        
        ArrayList<String> result = new ArrayList<String>();
        helper(0, digits, "", rec, result);
        
        return result;
    }
    
    private void helper(int index, String digits, String cur, HashMap<Character, String> rec, ArrayList<String> result) {
        if (index == digits.length()) {
            result.add(cur);
            return;
        }
        
        char digit = digits.charAt(index);
        String str = rec.get(digit);
        for (int i = 0; i < str.length(); i++) {
            helper(index + 1, digits, cur + str.charAt(i), rec, result);
        }
    }
}
