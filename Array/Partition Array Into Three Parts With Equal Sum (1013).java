class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum();
        
        if (sum % 3 != 0) {
            return false;
        }
        
        int curr = 0;
        int count = 0;
        
        for (int i : A) {
            curr += i;
            
            if (curr == sum / 3) {
                curr = 0;
                
                if (++count == 2) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
