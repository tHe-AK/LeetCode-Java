/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        
        if (n <= 0) {
            return count;
        }
        
        char[] buffer = new char[4];
        int start = 0;
        int size = 0;
    
        while (n > 0) {
            if (size == 0) {
                size = read4(buffer);
                
                if (size == 0) {
                    return count;
                }
            }

            if (size <= n) {
                System.arraycopy(buffer, start, buf, count, size);
                count += size;
                n -= size;
                start = 0;
                size = 0;
            }
            else {
                System.arraycopy(buffer, start, buf, count, n);
                start += n;
                size -= n;
                count += n;
                n = 0;
            }
        }
        
        return count;
    }
}
