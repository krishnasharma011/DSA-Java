class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for(int[][] arr : dp) {
            for(int[] temp : arr) {
                Arrays.fill(temp, -1);
            }
        }
        int ans = solve(m, n, maxMove, startRow, startColumn, dp);
        return ans;
    }

    private int solve(int m, int n, int maxMove, int sr, int sc, int[][][] dp) {
        if(sr == - 1 || sc == -1 || sr == m || sc == n)
            return 1;
        if(maxMove == 0)
            return 0;
        if (dp[sr][sc][maxMove] != -1)
            return dp[sr][sc][maxMove];
        int u = solve(m, n, maxMove - 1, sr - 1, sc, dp);
        int l = solve(m, n, maxMove - 1, sr, sc - 1, dp);
        int d = solve(m, n, maxMove - 1, sr + 1, sc, dp);
        int r = solve(m, n, maxMove - 1, sr, sc + 1, dp);
        return dp[sr][sc][maxMove] = (int)(((long) u + l + d + r) % 1_000_000_007);
    }
}