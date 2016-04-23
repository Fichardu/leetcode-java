// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// The same repeated number may be chosen from C unlimited number of times.
//
// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7,
// A solution set is:
// [7]
// [2, 2, 3]

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinCore(result, path, candidates, target, 0);
        return result;
    }

    public void combinCore(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i=index; i<candidates.length; ++i) {
            if (candidates[i] > target) {
                break;
            }

            path.add(candidates[i]);
            combinCore(res, path, candidates, target-candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
