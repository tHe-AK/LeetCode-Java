class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        if (A == null || A.length < 3 || A[0].length < 3) {
            throw new IllegalArgumentException();
        }
        
        int iLow = 0;
        int iHigh = A.length - 1;
        int jLow = 0;
        int jHigh = A[0].length - 1;
        boolean flag = true;
        List<Integer> result = new ArrayList<Integer>();
        
        while (iLow + 1 < iHigh && jLow + 1 < jHigh) {
            if (flag) {
                int iMid = iLow + (iHigh - iLow) / 2;
                int j = jLow;
                
                for (int x = jLow + 1; x <= jHigh; x++) {
                    if (A[iMid][x] > A[iMid][j]) {
                        j = x;
                    }
                }
                
                if (A[iMid - 1][j] < A[iMid][j] && A[iMid][j] > A[iMid + 1][j]) {
                    result.add(iMid);
                    result.add(j);
                    
                    return result;
                }
                else if (A[iMid - 1][j] > A[iMid][j]) {
                    iHigh = iMid;
                }
                else {
                    iLow = iMid;
                } 
            }
            else {
                int jMid = jLow + (jHigh - jLow) / 2;
                int i = iLow;
                
                for (int x = iLow + 1; x <= iHigh; x++) {
                    if (A[x][jMid] > A[i][jMid]) {
                        i = x;
                    }
                }
                
                if (A[i][jMid - 1] < A[i][jMid] && A[i][jMid] > A[i][jMid + 1]) {
                    result.add(i);
                    result.add(jMid);
                    
                    return result;
                }
                else if (A[i][jMid - 1] > A[i][jMid]) {
                    jHigh = jMid;
                }
                else {
                    jLow = jMid;
                }
            }
            
            flag = !flag;
        }
        
        throw new IllegalArgumentException();
    }
}

