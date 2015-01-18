/**
 *Implement strStr().
 *
 *Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        } else if (haystack.length() == 0) {
            return -1;
        }
        
        char[] src = haystack.toCharArray();
        char[] des = needle.toCharArray();
        
        for (int i=0; i<src.length; ++i) {
            if (src[i] != des[0]) {
                while(++i<src.length && src[i] != des[0]);
            }
            
            int start = i;
            int j = 0;
            while (start<src.length && j<des.length && src[start] == des[j]) {
                ++start;
                ++j;
            }
            
            if (j == des.length) {
                return start - j;
            }
            
        }
        return -1;
        
    }
    
    
    // KMP
    private int strStrKMP(String haystack, String needle) {
        char[] src = haystack.toCharArray();
        char[] des = needle.toCharArray();
        int[] next = getNext(des);
        int i=0, j=0;
        while (i < src.length && j < des.length) {
            if (j == -1 || src[i] == des[j]) {
                ++j;
                ++i;
            } else {
                j = next[j];
            }
        }
        
        if (j == des.length) {
            return i - j;
        } else {
            return -1;
        }
        
    }

    private int[] getNext(char[] p) {
        int[] next = new int[p.length];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}