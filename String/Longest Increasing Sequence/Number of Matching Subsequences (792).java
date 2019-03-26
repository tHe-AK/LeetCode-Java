class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Queue<int[]>[] record = new LinkedList[26];
        int count = 0;
        
        for (int i = 0; i < 26; i++) {
            record[i] = new LinkedList<int[]>();
        }
        
        for (int i = 0; i < words.length; i++) {
            record[words[i].charAt(0) - 'a'].offer(new int[] { i, 0 });
        }
        
        for (char ch : S.toCharArray()) {
            int size = record[ch - 'a'].size();
            
            for (int i = 0; i < size; i++) {
                int[] pair = record[ch - 'a'].poll();
                String word = words[pair[0]];
                int idx = ++pair[1];
                
                if (idx == word.length()) {
                    count++;
                } else {
                    record[word.charAt(idx) - 'a'].offer(pair);
                }
            }
        }
        
        return count;
    }
}
