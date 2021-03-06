/**
 * Created by yaodh on 2014/11/25.
 * <p/>
 * LeetCode: Trapping Rain Water
 * Link: https://oj.leetcode.com/problems/trapping-rain-water/
 * Description:
 * -----------------------------
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * -----------------------------
 * <p/>
 * Tag: TwoPointers
 */
public class TrappingRainWater {
//    public int trap(int[] A) {
//        if (A.length <= 2) return 0;
//        int ans = 0;
//        int p = 0, q = A.length - 1;
//        int left = 0, right = 0;
//        while (p < q) {
//            if (A[p] < A[q]) {
//                while (p < q && A[p] <= left) {
//                    ans += left - A[p];
//                    p++;
//                }
//                if (p < q) left = A[p];
//            } else {
//                while (p < q && A[q] <= right) {
//                    ans += right - A[q];
//                    q--;
//                }
//                if (p < q) right = A[q];
//            }
//        }
//        return ans;
//    }

    public int trap(int[] A) {
        if (A.length <= 0) {
            return 0;
        }
        int n = A.length - 1, maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > A[maxIdx]) {
                maxIdx = i;
            }
        }
        int water = 0;
        water += binaryWater(A, maxIdx, 0, 1);
        water += binaryWater(A, maxIdx, n - 1, -1);
        return water;
    }

    private int binaryWater(int[] A, int maxIdx, int start, int dir) {
        int water = 0;
        for (int i = start, peek = 0; i != maxIdx; i += dir) {
            if (A[i] > peek) {
                peek = A[i];
            } else {
                water += peek - A[i];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int ans = new TrappingRainWater().trap(new int[]{5, 4, 1, 2});
        System.out.println(ans);
    }
}
// 5,2,1,2,1,5 14
// 5,4,1,2  1
// 0,2,0 0
// 6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3 -->83