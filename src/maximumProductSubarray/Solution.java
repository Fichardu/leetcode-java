// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

public class Solution {
    public int maxProduct(int[] nums) {
        int r = nums[0];
        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            r = Math.max(r, imax);
        }
        return r;
    }
}
