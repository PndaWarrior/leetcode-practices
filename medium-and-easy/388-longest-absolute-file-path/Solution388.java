class Solution388 {
    public int lengthLongestPath(String input) {
        
        String[] strings = input.split("\n");
        int[] stringLengths = new int[strings.length];
        int answer = 0;
        for (String currentString : strings) {
            int lastTabIndex = currentString.lastIndexOf("\t");
            int currentLength = currentString.substring(lastTabIndex+1, currentString.length()).length();
            if(lastTabIndex == -1) {
                stringLengths[0] = currentLength;
            } else {
                stringLengths[lastTabIndex + 1] = stringLengths[lastTabIndex] + currentLength + 1;
            }
            if(currentString.contains(".")) {
                answer = Math.max(answer, stringLengths[lastTabIndex + 1]);
            }
        }
        
        return answer;
        
    }
}