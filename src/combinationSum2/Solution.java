// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// Each number in C may only be used once in the combination.
//
// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8,
// A solution set is:
// [1, 7]
// [1, 2, 5]
// [2, 6]
// [1, 1, 6]

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combCore(result, path, candidates, target, 0);
        return result;
    }

    public void combCore(List<List<Integer>> res, List<Integer> path, int[] nums, int target, int pos) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (pos >= nums.length || target < 0) {
            return;
        }
        int prev = -1;
        for (int i=pos; i<nums.length; ++i) {
            if (nums[i] != prev) {
                path.add(nums[i]);
                combCore(res, path, nums, target - nums[i], i+1);
                path.remove(path.size() - 1);
                prev = nums[i];
            }
        }
    }
}
