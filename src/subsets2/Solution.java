// Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If nums = [1,2,2], a solution is:
//
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        subsets(res, list, nums, 0);
        return res;
    }

    private void subsets(List<List<Integer>> res, List<Integer> list, int[] nums, int pos) {
        res.add(new ArrayList<>(list));

        for (int i = pos; i < nums.length; ++i) {
            if (i != pos && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            subsets(res, list, nums, i+1);
            list.remove(list.size() - 1);
        }

    }
}
