/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int k = 0; k < 10; k++) {
            int N = wordlist.length;
            int[] count = new int[N];
            
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (getSimilarity(wordlist[i], wordlist[j]) == 0) {
                        count[i]++;
                        count[j]++;
                    }
                }
            }
            
            int idx = 0;
            
            for (int i = 1; i < N; i++) {
                if (count[i] < count[idx]) {
                    idx = i;
                }
            }
            
            int match = master.guess(wordlist[idx]);
            
            if (match == 6) {
                return;
            }
            
            List<String> list = new ArrayList<>();
            
            for (String word : wordlist) {
                if (getSimilarity(wordlist[idx], word) == match) {
                    list.add(word);
                } 
            }
            
            wordlist = list.toArray(new String[0]);
        }
    }
    
    private int getSimilarity(String str1, String str2) {
        int count = 0;
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                count++;
            }
        }
        
        return count;
    }
}
