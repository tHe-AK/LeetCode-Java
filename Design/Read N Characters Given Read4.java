/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int bufIdx = 0;
        int tempIdx = 0;
        
        while (bufIdx < n) {
            int count = read4(temp);
            
            if (count == 0) {
                return bufIdx;
            }
            
            tempIdx = 0;
            
            while (bufIdx < n && tempIdx < count) {
                buf[bufIdx++] = temp[tempIdx++];
            }
        }
        
        return bufIdx;
    }
}
