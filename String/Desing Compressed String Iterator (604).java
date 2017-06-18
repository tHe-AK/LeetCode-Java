public class StringIterator {
    private String s;
    private int idx = 0;
    private int count = 0;
    private char ch = ' ';
    
    public StringIterator(String s) {
        this.s = s;
    }
    
    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        
        if (count == 0) {
            ch = s.charAt(idx++);
            
            while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                count = count * 10 + res.charAt(idx++) - '0';
            }
        } else {
            count--;
        }
        
        return ch;
    }
    
    public boolean hasNext() {
        return idx != res.length() || count != 0;
    }
}
