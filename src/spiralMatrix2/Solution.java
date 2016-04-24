// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
// For example,
// Given n = 3,
//
// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int xStart = 0;
        int yStart = 0;
        int num = 1;
        if (n == 1) {
            res[0][0] = 1;
            return res;
        }

        while (n > 0) {
            for (int i=0; i<n; ++i) {
                res[yStart][xStart+i] = num++;
            }
            for (int i=1; i<n; ++i) {
                res[yStart+i][xStart+n-1] = num++;
            }
            for (int i=1; i<n; ++i) {
                res[yStart+n-1][xStart+n-1-i] = num++;
            }
            for (int i=1; i<n-1; ++i) {
                res[yStart+n-1-i][xStart] = num++;
            }
            n -= 2;
            xStart++;
            yStart++;
        }
        return res;
    }
}
