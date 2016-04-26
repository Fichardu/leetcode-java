// You are given an n x n 2D matrix representing an image.
//
// Rotate the image by 90 degrees (clockwise).

public class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;

        for (int i=0; i<m; ++i) {
            for (int j=i+1; j<m; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int mid = m/2;
        for (int i=0; i<m;++i) {
            for (int j=0; j<mid; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-1-j];
                matrix[i][m-1-j] = temp;
            }
        }
    }
}
