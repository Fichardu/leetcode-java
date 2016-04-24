// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
// Note:
// You are not suppose to use the library's sort function for this problem.

public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                ++left;
                ++i;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                --right;
            } else {
                ++i;
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
