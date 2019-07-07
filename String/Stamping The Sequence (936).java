class Solution {
    public int[] movesToStamp(String stamp, String target) {
        int N = stamp.length();
        String replacedStamp = getReplacedStr(N);
        String replacedTarget = getReplacedStr(target.length());
        List<Integer> list = new ArrayList<>();
        
        while (!target.equals(replacedTarget)) {
            int idx = getIdx(target, stamp);
            
            if (idx == -1) {
                return new int[0];
            }
            
            list.add(idx);
            target = target.substring(0, idx) + replacedStamp + target.substring(idx + N);
        }
        
        int[] res = new int[list.size()];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - i - 1);
        }
        
        return res;
    }
    
    private int getIdx(String target, String stamp) {
        int M = target.length();
        int N = stamp.length();
        
        for (int i = 0; i <= M - N; i++) {
            int j = i;
            boolean isFound = false;
            
            while (j - i < N) {
                if (target.charAt(j) == stamp.charAt(j - i)) {
                    isFound = true;
                    j++;
                } else if (target.charAt(j) == '?') {
                    j++;
                } else {
                    break;
                }
            }
            
            if (j - i == N && isFound) {
                return i;
            }
        }
        
        return -1;
    }
    
    private String getReplacedStr(int N) {
        char[] array = new char[N];
        Arrays.fill(array, '?');
        return new String(array);
    }
}
