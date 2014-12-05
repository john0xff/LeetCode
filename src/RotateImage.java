/**
 * Created by yaodh on 2014/11/24.
 * <p/>
 * LeetCode: Rotate Image
 * Link: https://oj.leetcode.com/problems/rotate-image/
 * Description:
 * -----------------------------
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * -----------------------------
 * <p/>
 * Tag: Array
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        for (int i = 0; i < row / 2; i++) {
            for (int j = i; j < row - 1 - i; j++) {
                int tmp = matrix[i][j];
                int x = i, y = j;
                for (int k = 0; k < 3; k++) {
                    int tx = row - 1 - y, ty = x;
                    matrix[x][y] = matrix[tx][ty];
                    x = tx;
                    y = ty;
                }
                matrix[x][y] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        new RotateImage().rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
