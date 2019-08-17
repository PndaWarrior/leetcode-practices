import java.util.Arrays;

class Solution937 {
    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (a,b) -> {
            String[] aSplit = a.split(" ", 2);
            String[] bSplit = b.split(" ", 2);

            boolean aIsDigit = Character.isDigit(aSplit[1].charAt(0));
            boolean bIsDigit = Character.isDigit(bSplit[1].charAt(0));

            if(aIsDigit && bIsDigit) {
                return 0;
            } else if (aIsDigit && !bIsDigit) {
                return 1;
            } else if (!aIsDigit && bIsDigit) {
                return -1;
            } else {
                int compared = aSplit[1].compareTo(bSplit[1]);
                if(compared != 0) return compared;
                return aSplit[0].compareTo(bSplit[0]);
            }

        });

        return logs;
    }

}
