class Solution {
    public String similarRGB(String color) {
        String res = "#";
        
        for (int i = 1; i < color.length(); i += 2) {
            int num = Integer.parseInt(color.substring(i, i + 2), 16);
            int hex = num / 0x11 + (num % 0x11 > 8 ? 1 : 0);
            String str = Integer.toHexString(hex);
            res += str + str;
        }

        return res;
    }
}

class Solution {
    public String similarRGB(String color) {
        String res = "#";
        String base = "0123456789abcdef";
        
        for (int i = 1; i < color.length(); i += 2) {
            int num = Integer.parseInt(color.substring(i, i + 2), 16);
            String str = helper(num, base);
            res += str + str;
        }

        return res;
    }

    private String helper(int num, String base) {
        String res = null;
        int min = Integer.MAX_VALUE;
        int idx = num / 16;

        for (int i = -1; i <= 1; i++) {
            int start = (idx + i + 16) % 16;
            String str = base.substring(start, start + 1);
            int dist = Math.abs(Integer.parseInt(str + str, 16) - num);

            if (dist < min) {
                res = str;
                min = dist;
            }
        }

        return res;
    }
}
