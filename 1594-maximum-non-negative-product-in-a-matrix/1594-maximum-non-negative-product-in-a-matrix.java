class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxDP = new long[m][n];
        long[][] minDP = new long[m][n];
        boolean[][] visited = new boolean[m][n];
        long[] ans = solve(0, 0, grid, maxDP, minDP, visited);
        if (ans[0] < 0)
            return -1;

        return (int) (ans[0] % 1_000_000_007);
    }

    private long[] solve(int i, int j, int[][] grid, long[][] maxDP, long[][] minDP, boolean[][] visited) {
        if (i == grid.length || j == grid[0].length)
            return null;

        if (i == grid.length - 1 && j == grid[0].length - 1)
            return new long[] { grid[i][j], grid[i][j] };

        if (visited[i][j])
            return new long[] { maxDP[i][j], minDP[i][j] };
        long max_val = Long.MIN_VALUE;
        long min_val = Long.MAX_VALUE;
        long[] down = solve(i + 1, j, grid, maxDP, minDP, visited);
        long[] right = solve(i, j + 1, grid, maxDP, minDP, visited);
        if (down != null) {
            max_val = Math.max(max_val, Math.max(grid[i][j] * down[0],grid[i][j] * down[1]));
            min_val = Math.min(min_val, Math.min(grid[i][j] * down[0],grid[i][j] * down[1]));
        }

        if (right != null) {
            max_val = Math.max(max_val, Math.max(grid[i][j] * right[0],grid[i][j] * right[1]));
            min_val = Math.min(min_val, Math.min(grid[i][j] * right[0],grid[i][j] * right[1]));
        } 
        maxDP[i][j] = max_val;
        minDP[i][j] = min_val;
        visited[i][j] = true;
        return new long[] {max_val,min_val};
    }
}