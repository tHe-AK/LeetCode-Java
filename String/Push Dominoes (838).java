class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for (int i = 1; i < dominoes.length(); i++) {
            char curr = dominoes.charAt(i);
            
            if (curr != '.') {
                int count = i - idx - 1;
                char prev = dominoes.charAt(idx);
                
                if (idx > 0) {
                    sb.append(prev);
                }
                
                if (prev == curr) {
                    for (int k = 0; k < count; k++) {
                        sb.append(curr);
                    }
                } else if (prev == 'L' && curr == 'R') {
                    for (int k = 0; k < count; k++) {
                        sb.append('.');
                    }
                } else {
                    for (int k = 0; k < count / 2; k++) {
                        sb.append('R');
                    }
                    
                    if (count % 2 == 1) {
                        sb.append('.');
                    }
                    
                    for (int k = 0; k < count / 2; k++) {
                        sb.append('L');
                    }
                }
                
                idx = i;
            }
        }
        
        return sb.toString();
    }
}
