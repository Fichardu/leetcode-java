/**
 *You are climbing a stair case. It takes n steps to reach to the top.
 *
 *Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class Solution {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int[] st = new int[] {2, 3};
        for (int i=4; i<=n; ++i) {
            int t = st[0] + st[1];
            st[0] = st[1];
            st[1] = t;
        }
        return st[1];
    }
}