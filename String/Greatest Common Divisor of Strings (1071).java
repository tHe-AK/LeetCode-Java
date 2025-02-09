class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } else if (str2.length() == 0) {
            return str1;
        } else if (!str1.startsWith(str2)) {
            return "";
        } else {
            return gcdOfStrings(str2, str1.substring(str2.length()));
        }
    }
}
