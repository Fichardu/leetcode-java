// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size()+1];
        for (int i=triangle.size()-1; i>=0; --i) {
            List<Integer> arr = triangle.get(i);
            for (int j=0; j<arr.size(); ++j) {
                res[j] = Math.min(res[j], res[j+1]) + arr.get(j);
            }
        }
        return res[0];
    }
}
