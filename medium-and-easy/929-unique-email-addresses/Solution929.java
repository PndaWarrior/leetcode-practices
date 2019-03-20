import java.util.HashSet;

class Solution929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        
        for(String email : emails) {
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            String rest = email.substring(atIndex, email.length());
            int plusIndex = local.indexOf('+');
            if(plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }
            local = local.replace(".", "");
            
            set.add(local+rest);
        }
        
        return set.size();
        
    }
}