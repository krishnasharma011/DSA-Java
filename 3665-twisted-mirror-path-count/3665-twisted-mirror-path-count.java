class Solution {
    static final int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        for (int[][] arr : dp) {
            for (int[] temp : arr) {
                Arrays.fill(temp, -1);
            }
        }
        int ans = 0;
        ans = (ans + solve(0, 1, 0, grid, dp)) % MOD;
        ans = (ans + solve(1, 0, 1, grid, dp)) % MOD;
        return ans;
    }

    private int solve(int i, int j, int prev, int[][] grid, int[][][] dp) {
        if (i == grid.length || j == grid[0].length )
            return 0;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return 1;
        if (dp[i][j][prev] != -1)
            return dp[i][j][prev];
        int right = 0;
        int down = 0;
        if (grid[i][j] == 1) {
            if(prev == 1){
                right = solve(i, j + 1, 0, grid, dp);
            } else {
                down = solve(i + 1, j, 1, grid, dp);
            }
        } else {
            right = solve(i, j + 1, 0, grid, dp);
            down = solve(i + 1, j, 1, grid, dp);
        }
        return dp[i][j][prev] = (( down + right) % MOD);
    }
}