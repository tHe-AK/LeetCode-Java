/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private char[] temp = new char[4];
    private int tempIdx = 0;
    private int tempCnt = 0;
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int bufIdx = 0;
        
        while (bufIdx < n) {
            if (tempIdx == 0) {
                tempCnt = read4(temp);
                
                if (tempCnt == 0) {
                    return bufIdx;
                }
            }
            
            while (bufIdx < n && tempIdx < tempCnt) {
                buf[bufIdx++] = temp[tempIdx++];
            }
            
            if (tempIdx == tempCnt) {
                tempIdx = 0;
            }
        }
        
        return bufIdx;
    }
}
