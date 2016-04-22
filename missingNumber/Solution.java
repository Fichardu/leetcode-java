// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
// For example,
// Given nums = [0, 1, 3] return 2.
//

public class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i=0; i<nums.length; ++i) {
            result ^= i;
            result ^= nums[i];
        }
        return result;
    }

    public int missingNumber2(int[] nums) {
        int result = nums.length;
        for (int i=0; i<nums.length; ++i) {
            result += (i-nums[i]);
        }
        return result;
    }
}
