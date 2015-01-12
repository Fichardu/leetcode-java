/**
 *Given a non-negative number represented as an array of digits, plus one to the number.
 *
 *The digits are stored such that the most significant digit is at the head of the list.
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = digits.length - 1;
        while (index >= 0) {
            int tp = digits[index] + carry;
            if (tp >= 10) {
                digits[index] = tp - 10;
                carry = 1;
            } else {
                digits[index] = tp;
                carry = 0;
            }
            --index;
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
    
}