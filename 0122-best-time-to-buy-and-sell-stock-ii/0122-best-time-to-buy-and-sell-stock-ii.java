class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int[][] dp = new int[n][2];
        dp[n-1][0] = prices[n-1];
        dp[n-1][1] = 0;
        for(int i=n-2; i>=0; i--) {
            dp[i][0] = Math.max(prices[i] + dp[i+1][1] , dp[i+1][0]);
            dp[i][1] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
        }
        return dp[0][1];
    }
}