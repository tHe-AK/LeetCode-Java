class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int N = seq.length();
        int[] res = new int[N];
        int count = 0;
        
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                res[i] = ++count % 2;
            } else {
                res[i] = count-- % 2;
            }
        }
        
        return res;
    }
}
