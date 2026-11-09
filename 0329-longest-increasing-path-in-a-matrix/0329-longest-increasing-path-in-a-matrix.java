class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1)
            return 1;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, solve(i, j, matrix, dp));
            }
        }
        return ans;
    }

    private int solve(int i, int j, int[][] matrix, int[][] dp) {
        if (i < 0 || j < 0 || i == matrix.length || j == matrix[0].length)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int l = 0;
        int r = 0;
        int d = 0;
        int u = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            u = solve(i - 1, j, matrix, dp);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            l = solve(i, j - 1, matrix, dp);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            d = solve(i + 1, j, matrix, dp);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            r = solve(i, j + 1, matrix, dp);
        }
        return dp[i][j] = 1 + Math.max(u, Math.max(l, Math.max(d, r)));
    }
}