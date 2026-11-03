class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int[][] dp = new int[n][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        int ans = solve(0, 1,prices, dp);
        return ans;
    }

    private int solve(int idx, int buy, int[] prices, int[][] dp) {
        if(idx >= prices.length) return 0;
        if(dp[idx][buy] != Integer.MIN_VALUE) return dp[idx][buy];
        if(buy == 1) {
            int x = -prices[idx] + solve(idx + 1, 0, prices, dp);
            int y = solve(idx + 1, 1, prices, dp);
            dp[idx][buy] = Math.max(x, y);
        } else {
            int x = prices[idx] + solve(idx + 2, 1, prices, dp);
            int y = solve(idx + 1, 0, prices, dp);
            dp[idx][buy] = Math.max(x, y);
        }
        return dp[idx][buy];
    }
}