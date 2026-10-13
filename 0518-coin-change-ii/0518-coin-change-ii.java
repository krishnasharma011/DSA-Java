class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return solve(0, amount, coins, dp);
    }

    private int solve(int idx, int amount, int[] coins, int[][] dp) {
        if (amount == 0)
            return 1;
        if (idx == coins.length)
            return 0;
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int skip = solve(idx + 1, amount, coins, dp);
        int take = 0;
        if (amount >= coins[idx])
            take = solve(idx, amount - coins[idx], coins, dp);
        return dp[idx][amount] = take + skip;
    }
}