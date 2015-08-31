public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null) {
            throw new IllegalArgumentException();
        }
        
        int min = Integer.MIN_VALUE;
        int cur = -1;
        
        for (int i = 0; i < preorder.length; i++) {
            while (cur >= 0 && preorder[i] > preorder[cur]) {
                min = preorder[cur];
                cur--;
            }
            
            if (preorder[i] < min) {
                return false;
            }

            cur++;
            preorder[cur] = preorder[i];
        }
        
        return true;
    }
}
