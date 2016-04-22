// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
// Ensure that numbers within the set are sorted in ascending order.
//
//
// Example 1:
//
// Input: k = 3, n = 7
//
// Output:
//
// [[1,2,4]]
//
// Example 2:
//
// Input: k = 3, n = 9
//
// Output:
//
// [[1,2,6], [1,3,5], [2,3,4]]

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combinationCore(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }

    private void combinationCore(List<List<Integer>> res, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i=start; i<=9; ++i) {
            comb.add(i);
            combinationCore(res, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
