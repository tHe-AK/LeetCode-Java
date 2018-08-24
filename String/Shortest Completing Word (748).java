class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = new int[26];
        int total = 0;
        String str = null;
        
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            
            if (Character.isLetter(ch)) {
                int idx = Character.toLowerCase(ch) - 'a';
                target[idx]++;
                total++;
            }
        }
        
        for (String word : words) {
            if (str == null || word.length() < str.length()) {
                int[] dict = new int[26];
                int count = total;
                
                for (int i = 0; i < word.length(); i++) {
                    int idx = word.charAt(i) - 'a';
                    
                    if (dict[idx]++ < target[idx]) {
                        count--;
                    }
                }

                if (count == 0) {
                    str = word;
                }
            }
        }
        
        return str;
    }
}
