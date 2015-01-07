public class Solution {
    public String convert(String s, int nRows) {
        int len = s.length();
        if (nRows == 1) {
            return s;
        }
        
        char[] res = new char[len];
        int j = 0;
        int step = nRows*2 - 2;
        for (int row=0; row<nRows; ++row) {
            int subStep = step - 2*row;
            for (int i=row; i<len; i+=step) {
                res[j++] = s.charAt(i);
                if (row>0 && row<nRows-1 && i+subStep<len) {
                    res[j++] = s.charAt(i+subStep);
                }
            }
        }
        
        return new String(res);
        
    }
}