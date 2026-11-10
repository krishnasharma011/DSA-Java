class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, costs, dp);
    }

    private int solve(int n, int[] costs, int[] dp) {
        if (n <= 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int a = solve(n - 1, costs, dp) + costs[n - 1] + 1;
        int b = solve(n - 2, costs, dp) + costs[n - 1] + 4;
        int c = solve(n - 3, costs, dp) + costs[n - 1] + 9;
        return dp[n] = Math.min(a, Math.min(b, c));
    }
}