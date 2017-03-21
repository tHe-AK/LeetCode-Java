public class Codec {
    private String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Map<String, String> map = new HashMap<>();
    private Random rand = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getRand();
        
        while (map.containsKey(key)) {
            key = getRand();
        }
        
        map.put(key, longUrl);
        
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
    
    private String getRand() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
