public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        
        String result = "";
        String[] map = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        
        while (num != 0) {
            result = map[num & 0b1111] + result;
            num >>>= 4;
        }
        
        return result;
    }
}
