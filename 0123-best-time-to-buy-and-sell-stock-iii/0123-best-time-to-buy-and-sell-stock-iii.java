class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int[][][] dp = new int[n][2][3];
        for(int[][] arr:dp) {
            for(int[] temp:arr){
                Arrays.fill(temp, Integer.MIN_VALUE);
            }
        }
        int ans = solve(0,1,2,prices,dp);
        return ans;
    }

    private int solve(int idx, int buy, int limit, int[] prices,int[][][] dp) {
        if(idx == prices.length) return 0;
        if(dp[idx][buy][limit] != Integer.MIN_VALUE) return dp[idx][buy][limit];
        if(limit == 0) return 0;
        if(buy == 1) {
            int x = -prices[idx] + solve(idx + 1, 0, limit, prices, dp);
            int y = solve(idx + 1, 1, limit, prices, dp);
            dp[idx][buy][limit] = Math.max(x, y);
        } else {
            int x = prices[idx] + solve(idx + 1, 1, limit - 1, prices, dp);
            int y = solve(idx + 1, 0, limit, prices, dp);
            dp[idx][buy][limit] = Math.max(x, y);
        }
        return dp[idx][buy][limit];
    }
}