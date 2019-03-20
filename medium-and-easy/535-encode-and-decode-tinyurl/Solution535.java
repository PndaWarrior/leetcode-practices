import java.util.HashMap;
import java.util.Random;

public class Solution535 {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    HashMap<String, String> map = new HashMap<>();
    Random randomGenerator = new Random();
    String nextKey = getRandomString();
    
    public String getRandomString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            sb.append(alphabet.charAt(randomGenerator.nextInt(62)));
        }
        
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        while (map.containsKey(nextKey)) {
            nextKey = getRandomString();
        }
        
        map.put(nextKey, longUrl);
        return "https://tinyurl.com/" + nextKey;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("https://tinyurl.com/", ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));