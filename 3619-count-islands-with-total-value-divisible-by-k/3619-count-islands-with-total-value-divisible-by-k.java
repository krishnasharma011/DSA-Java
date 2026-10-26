class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    ans += bfs(grid, i, j, k, visited);
                }
            }
        }
        return ans;
    }

    private int bfs(int[][] grid, int i, int j, int k, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { i, j, grid[i][j] });
        visited[i][j] = true;
        long sum = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int a = temp[0];
            int b = temp[1];
            int c = temp[2];
            sum += c;

            if (a > 0 && !visited[a - 1][b] && grid[a - 1][b] != 0) {
                q.offer(new int[] { a - 1, b, grid[a - 1][b] });
                visited[a - 1][b] = true;
            }
            if (b > 0 && !visited[a][b - 1] && grid[a][b - 1] != 0) {
                q.offer(new int[] { a, b - 1, grid[a][b - 1] });
                visited[a][b - 1] = true;
            }
            if (a < m - 1 && !visited[a + 1][b] && grid[a + 1][b] != 0) {
                q.offer(new int[] { a + 1, b, grid[a + 1][b] });
                visited[a + 1][b] = true;
            }
            if (b < n - 1 && !visited[a][b + 1] && grid[a][b + 1] != 0) {
                q.offer(new int[] { a, b + 1, grid[a][b + 1] });
                visited[a][b + 1] = true;
            }
        }
        if (sum % k == 0)
            return 1;
        return 0;
    }
}