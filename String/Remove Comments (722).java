class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean block = false;

        for (String str : source) {
            int i = 0;
            
            while (i < str.length()) {
                char curr = str.charAt(i);
                    
                if (curr == '/' && i + 1 < str.length() && str.charAt(i + 1) == '/' && !block) {
                    break;
                } else if (curr == '/' && i + 1 < str.length() && str.charAt(i + 1) == '*' && !block) {
                    block = true;
                    i += 2;
                } else if (curr == '*' && i + 1 < str.length() && str.charAt(i + 1) == '/' && block) {
                    block = false;
                    i += 2;
                } else if (!block) {
                    sb.append(curr);
                    i++;
                } else {
                    i++;
                }
            }
            
            if (sb.length() > 0 && !block) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        
        return res;
    }
}
