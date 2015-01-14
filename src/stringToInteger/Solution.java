/**
 *Implement atoi to convert a string to an integer.
 */

public class Solution {
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int i = 0, result = 0;
        boolean nega = false;
        char[] array = str.toCharArray();
        while (array[i] == ' ') ++i;
        if (array[i] == '+' || array[i] == '-') {
            if (array[i++] == '-') {
                nega = true;
            }
        }
        int subMax = Integer.MAX_VALUE / 10;
        
        while (i<array.length && array[i] >= '0' && array[i] <= '9') {
            
            if (result > subMax || (result == subMax && array[i]-'0'>7)) {
                if (nega) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            result = result*10 + (int) (array[i++] - '0');
        }
        
        if (nega) return result * -1;
        else return result;
    }
}