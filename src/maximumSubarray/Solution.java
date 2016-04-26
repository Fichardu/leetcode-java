// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public class Solution {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = nums[0];
        for (int i=1; i<nums.length; ++i) {
            current = current < 0 ? nums[i] : (nums[i]+current);
            max = Math.max(max, current);
        }
        return max;
    }
}
