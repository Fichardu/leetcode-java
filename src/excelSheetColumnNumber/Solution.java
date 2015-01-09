public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int n = 0;
        for (int i=0; i<len; ++i) {
            int temp = s.charAt(i) - 'A';
            n = n * 26 + temp + 1;
        }
        return n;
        
    }
}