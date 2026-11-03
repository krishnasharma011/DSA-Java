class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n==1) return 0;
        int[][] dp = new int[n][2];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(0,prices,1,fee,dp);
    }

    private int solve(int idx, int[] prices, int buy, int fee, int[][] dp) {
        if (idx == prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        if(buy == 1){
            int a = -prices[idx] + solve(idx + 1, prices, 0, fee, dp);
            int b = solve(idx + 1, prices, 1, fee, dp);
            return dp[idx][buy] = Math.max(a, b);
        } else {
            int a = prices[idx] - fee + solve(idx + 1, prices, 1, fee, dp);
            int b = solve(idx + 1, prices, 0, fee, dp);
            return dp[idx][buy] = Math.max(a, b);
        }
    }
}