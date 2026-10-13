class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        int ans = solve(0, coins, amount, dp);
        if (ans == 1000000000)
            return -1;
        return ans;
    }

    private int solve(int idx, int[] coins, int amount, int[][] dp) {
        if (amount == 0)
            return 0;
        if (idx == coins.length)
            return (int) Math.pow(10, 9);
        if (dp[idx][amount] != -1)
            return dp[idx][amount];
        int pick = (int) Math.pow(10, 9);
        if (amount >= coins[idx])
            pick = 1 + solve(idx, coins, amount - coins[idx], dp);
        int skip = solve(idx + 1, coins, amount, dp);
        return dp[idx][amount] = Math.min(pick, skip);
    }
}