class Solution273 {
    
    public String translateBelowTwenty(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }
    
    public String translateAboveTwenty(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }
    
    public String additionalNumber(int level) {
        switch(level) {
            case 1: return " Thousand";
            case 2: return " Million";
            case 3: return " Billion";
        }
        return "";
    }
    
    public String convertFirstTwo(int num) {
        String result = "";
        
        if(num < 20) {
            result = translateBelowTwenty(num);
        } else {
            int remainder = num % 10;
            int tenth = num / 10;
            result = (remainder > 0) ? translateAboveTwenty(tenth) + " " + translateBelowTwenty(remainder) : translateAboveTwenty(tenth);
        }
        
        return  result;
    }
    
    public String convertFirstThree(int num) {
        String result = "";
        int remainder = 0;
        int hundred = 0;
        if(num >= 100) {
            remainder = num % 100;
            hundred = num / 100;
        } else {
            remainder = num;
        }
        
        if(hundred > 0) {
            result = (remainder > 0) ?  translateBelowTwenty(hundred) + " Hundred " :  translateBelowTwenty(hundred) + " Hundred";
        }
        
        result = result + convertFirstTwo(remainder);
        
        return result;
    }
    
    
    public String convertNumberToWords(int num, int level) {
        String result = "";
        int remainder = 0;
        int nextIteration = 0;
        if(num >= 1000) {
            remainder = num % 1000;
            nextIteration = num / 1000;
        } else {
            remainder = num;
        }
        result = convertFirstThree(remainder);
        result = (result.length() > 0) ? result + additionalNumber(level) : result;
        
        if(nextIteration > 0) {
            return convertNumberToWords(nextIteration, ++level).trim() + " " + result;
        }
        return result;

        
    }
    
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String answer = convertNumberToWords(num, 0);
        return answer.trim();
    }
}