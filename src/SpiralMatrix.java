import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Spiral Matrix
 * Link: https://oj.leetcode.com/problems/spiral-matrix/
 * Description:
 * -----------------------------
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * -----------------------------
 * <p/>
 * Tag: Array
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix.length <= 0) return ans;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = -1, k = 0, count = column;
        int visRows = 0, visColumns = 0;
        for (int i = 0; i < row * column; i++) {
            x += directions[k][0];
            y += directions[k][1];
            ans.add(matrix[x][y]);
            if (--count == 0) {
                if (k % 2 == 0) visRows++;
                else visColumns++;
                k = (k + 1) % 4;
                if (k % 2 == 0) count = column - visColumns;
                else count = row - visRows;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans = new SpiralMatrix().spiralOrder(new int[][]{{1}});
        System.out.println(ans);
    }
}
