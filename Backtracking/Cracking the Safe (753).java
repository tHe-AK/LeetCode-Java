class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        crackSafe(n, k, sb, visited);
        
        return sb.toString();
    }
    
    private boolean crackSafe(int n, int k, StringBuilder sb, Set<String> visited) {
        if (sb.length() == Math.pow(k, n) + n - 1) {
            return true;
        }
        
        String prev = sb.substring(sb.length() - n + 1);
        
        for (int i = 0; i < k; i++) {
            String str = prev + i;
            
            if (!visited.contains(str)) {
                sb.append(i);
                visited.add(str);
                
                if (crackSafe(n, k, sb, visited)) {
                    return true;
                }
                
                sb.deleteCharAt(sb.length() - 1);
                visited.remove(str);
            }
        }
        
        return false;
    }
}
