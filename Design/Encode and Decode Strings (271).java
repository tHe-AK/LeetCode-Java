public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            sb.append(str.length()).append(":").append(str);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<String>();
        int i = 0;
        
        while (i < s.length()) {
            int pos = s.indexOf(":", i);
            int len = Integer.parseInt(s.substring(i, pos));
            strs.add(s.substring(pos + 1, pos + 1 + len));
            i = pos + 1 + len;
        }
        
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
