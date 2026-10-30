class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        if (n == 1)
            return ans;
        int[][] dp = new int[n][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        ans = solve(0, 1, 0,prices, dp);
        return ans;
    }

    private int solve(int idx, int buy, int prev,int[] prices, int[][] dp) {
        if(idx == prices.length) return 0;
        if(dp[idx][buy] != Integer.MIN_VALUE) return dp[idx][buy];
        if(buy == 1) {
            int x = -prices[idx] + solve(idx + 1, 0, prev, prices, dp);
            int y = solve(idx + 1, 1, prev, prices, dp);
            dp[idx][buy] = Math.max(x, y);
        } else {
            int x = prices[idx] + solve(idx + 1, 1, prices[idx], prices, dp);
            int y = solve(idx + 1, 0, prev, prices, dp);
            dp[idx][buy] = Math.max(x, y);
        }
        return dp[idx][buy];
    }
}