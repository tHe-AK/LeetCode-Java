public class StringIterator {
    private String s;
    private int idx;
    private int count;
    private char ch;
    
    public Solution(String s) {
        this.s = s;
        idx = 0;
        count = 0;
    }
    
    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        
        if (count == 0) {
            ch = s.charAt(idx++);
            
            while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                count = count * 10 + s.charAt(idx++) - '0';
            }
        }

        count--;
        return ch;
    }
    
    public boolean hasNext() {
        return idx != s.length() || count != 0;
    }
}
