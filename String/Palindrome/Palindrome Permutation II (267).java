public class Solution {
    public List<String> generatePalindromes(String s) {
        int[] rec = new int[256];
        int count = 0;
        String str = "";
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            rec[s.charAt(i)]++;
        }
        
        for (int i = 0; i < rec.length; i++) {
            count += rec[i];
            
            if (rec[i] % 2 == 1) {
                if (str.length() == 0) {
                    str += (char) i;
                    rec[i]--;
                } else {
                    return result;
                }
            }
        }
        
        dfs(rec, count, str, result);
        
        return result;
    }
    
    private void dfs(int[] rec, int count, String str, List<String> result) {
        if (str.length() == count) {
            result.add(str);
            return;
        }
        
        for (int i = 0; i < rec.length; i++) {
            if (rec[i] > 0) {
                char ch = (char) i;
                rec[i] -= 2;
                
                dfs(rec, count, ch + str + ch, result);
                
                rec[i] += 2;
            }
        }
    }
}
