public class Solution {
    public List<String> generatePalindromes(String s) {
        int[] rec = new int[256];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            rec[s.charAt(i)]++;
        }
        
        for (int i = 0; i < rec.length; i++) {
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
        
        dfs(rec, count, sb, result);
        
        return result;
    }
    
    private void dfs(int[] rec, int count, StringBuilder sb, List<String> result) {
        if (sb.length() == count) {
            result.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < rec.length; i++) {
            if (rec[i] > 0) {
                char ch = (char) i;
                sb.insert(0, ch);
                sb.append(ch);
                rec[i] -= 2;
                
                dfs(rec, count, sb, result);
                
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
                rec[i] += 2;
            }
        }
    }
}
