import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution937SplitFirst {
    public String[] reorderLogFiles(String[] logs) {

      //Simple optimizaion.  Assuming that we have same number of letters and digits, we can simply create two lists, which makes it so we only need to sort the letters list, and we can simply append digist list onto the right

        List<String> letters = new LinkedList<String>();
        List<String> digits = new LinkedList<String>();

        for(String log : logs) {
            String[] split = log.split(" ", 2);
            if(Character.isDigit(split[1].charAt(0))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }



        Collections.sort(letters, (a,b) -> {
            String[] aSplit = a.split(" ", 2);
            String[] bSplit = b.split(" ", 2);

            boolean aIsDigit = Character.isDigit(aSplit[1].charAt(0));
            boolean bIsDigit = Character.isDigit(bSplit[1].charAt(0));

            int compared = aSplit[1].compareTo(bSplit[1]);
            if(compared != 0) return compared;
            return aSplit[0].compareTo(bSplit[0]);

        });

        letters.addAll(digits);

        return letters.toArray(new String[logs.length]);
    }

}
