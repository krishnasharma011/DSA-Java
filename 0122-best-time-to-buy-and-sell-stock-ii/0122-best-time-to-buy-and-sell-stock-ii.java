class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr:dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, 1, prices, dp);        
    }

    private int solve(int idx, int buy, int[] prices, int[][] dp) {
        if(idx == prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        int profit = 0;
        if(buy == 1) {
            int a = -prices[idx] + solve(idx + 1, 0, prices, dp);
            int b = solve(idx + 1, 1, prices, dp);
            profit = Math.max(a,b);
        }
        else {
            int a = prices[idx] + solve(idx + 1, 1, prices, dp);
            int b = solve(idx + 1, 0, prices, dp);
            profit = Math.max(a,b);
        }
        return dp[idx][buy] = profit;
    }
}