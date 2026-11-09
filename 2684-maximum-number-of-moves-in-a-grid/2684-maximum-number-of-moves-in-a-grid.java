class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = 0;
        for(int i = 0; i < m; i++) {
            ans = Math.max(ans, solve(i, 0, grid, dp));
        }
        return ans - 1;
    }

    private int solve(int r, int c, int[][] grid, int[][] dp) {
        if(r < 0 || r == grid.length || c == grid[0].length) 
            return 0;
        if(dp[r][c] != -1) 
            return dp[r][c];
        int x = 0;
        int y = 0;
        int z = 0;
        if(r -1 >= 0 && c + 1 < grid[0].length && grid[r - 1][c + 1] > grid[r][c]) 
            x = solve(r - 1, c + 1, grid, dp);
        if(c + 1 < grid[0].length && grid[r][c + 1] > grid[r][c])
            y = solve(r, c + 1, grid, dp);
        if(r + 1 < grid.length && c + 1 < grid[0].length && grid[r + 1][c + 1] > grid[r][c]) 
            z = solve(r + 1, c + 1, grid, dp);
        return dp[r][c] = 1 + Math.max(x, Math.max(y, z));
    }
}