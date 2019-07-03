class Solution482Simple {
    public String licenseKeyFormatting(String S, int K) {
        
        String temp = S.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(temp);
        
        System.out.println(temp);
        
        for (int i = K; i < temp.length(); i += K) {
            sb.insert(temp.length() - i, "-");
        }
        
        return sb.toString();
        
    }
}