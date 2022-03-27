package visa;

//https://leetcode.com/problems/maximal-square/solution/#:~:text=Whenever%20a%201%20is%20found,column%20are%201%20or%20not.
public class LargestNXNmatrix {
    public static void main(String[] args) {
        int myArr[][] = {
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0}
        };
                LargestNXNmatrix obj = new LargestNXNmatrix();

        System.out.println(obj.maximalSquare(myArr));
    }
    public int maximalSquare(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == 1) {
                    //dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    dp[j] = Math.min(Math.min(prev, dp[j]), dp[j - 1]) + 1;
                    //we basically need minimum among the 3 variables
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                    //System.out.print(" if->dp[j]:"+j+"-->"+dp[j]);
                } else {
                    dp[j] = 0;
                    //System.out.print(" else->dp[j]:"+j+"-->"+dp[j]);
                }
                prev = temp;
            }
            System.out.println();
        }
        return maxsqlen * maxsqlen;
    }
}