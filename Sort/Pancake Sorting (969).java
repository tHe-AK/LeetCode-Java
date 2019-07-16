class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = A.length - 1; i > 0; i--) {
            int j = 0;
            
            while (A[j] != i + 1) {
                j++;
            }
            
            if (j != i) {
                if (j != 0) {
                    reverse(A, j);
                    list.add(j + 1);
                }
                
                reverse(A, i);
                list.add(i + 1);
            }
        }
        
        return list;
    }
    
    private void reverse(int[] A, int j) {
        int i = 0;
        
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}
