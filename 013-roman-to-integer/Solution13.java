class Solution13 {
    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length() ; i ++) {
            switch(s.charAt(i)) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if((i+1 < s.length()) && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                        result -= 100;
                        break;
                    } else {
                        result += 100;
                        break;
                    }
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if((i+1 < s.length()) && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                        result -= 10;
                        break;
                    } else {
                        result += 10;
                        break;
                    }
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    if((i+1 < s.length()) && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                        result -= 1;
                        break;
                    } else {
                        result += 1;
                        break;
                    }
                default :
                    break;

            }

        }
        return result;

    }
}
