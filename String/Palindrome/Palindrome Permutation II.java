public class Solution {
    public List<String> generatePalindromes(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int[] rec = new int[256];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        List<String> result = new ArrayList<String>();
        
        for (int i = 0; i < s.length(); i++) {
            rec[s.charAt(i)]++;
        }
        
        for (int i = 0; i < 256; i++) {
            count += rec[i];
            
            if (rec[i] % 2 == 1) {
                if (sb.length() == 0) {
                    sb.append((char) i);
                    rec[i]--;
                } else {
                    return result;
                }
            }
        }
        
        helper(rec, count, sb, result);
        
        return result;
    }
    
    private void helper(int[] rec, int count, StringBuilder sb, List<String> result) {
        if (sb.length() == count) {
            result.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < rec.length; i++) {
            if (rec[i] > 0) {
                sb.insert(0, (char) i);
                sb.append((char) i);
                rec[i] -= 2;
                
                helper(rec, count, sb, result);
                
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
                rec[i] += 2;
            }
        }
    }
}
