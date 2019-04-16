class Solution {
    public String similarRGB(String color) {
        String str = "#";
        
        for (int i = 1; i < color.length(); i += 2) {
            int num = Integer.parseInt(color.substring(i, i + 2), 16);
            int digit = num / 0x11 + (num % 0x11 > 8 ? 1 : 0);
            String hex = Integer.toHexString(digit);
            str += hex + hex;
        }

        return str;
    }
}

class Solution {
    public String similarRGB(String color) {
        String str = "#";
        String base = "0123456789abcdef";
        
        for (int i = 1; i < color.length(); i += 2) {
            int num = Integer.parseInt(color.substring(i, i + 2), 16);
            String hex = helper(num, base);
            str += hex + hex;
        }

        return str;
    }

    private String helper(int num, String base) {
        String str = null;
        int min = Integer.MAX_VALUE;
        int idx = num / 16;

        for (int i = -1; i <= 1; i++) {
            int start = (idx + i + 16) % 16;
            String digit = base.substring(start, start + 1);
            int dist = Math.abs(Integer.parseInt(digit + digit, 16) - num);

            if (dist < min) {
                str = digit;
                min = dist;
            }
        }

        return str;
    }
}
