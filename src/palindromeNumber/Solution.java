/**
 *Determine whether an integer is a palindrome. Do this without extra space.
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x !=0 && x % 10 == 0) {
            return false;
        } 
        int y = 0;
        while (y < x) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if (x == y || y / 10 == x) {
            return true;
        } else {
            return false;
        }
    }
}