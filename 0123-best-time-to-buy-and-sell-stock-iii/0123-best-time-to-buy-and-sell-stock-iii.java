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
        int ans = solve(0,1,0,prices,dp);
        return ans;
    }

    private int solve(int idx, int buy, int time, int[] prices,int[][][] dp) {
        if(idx == prices.length) return 0;
        if(dp[idx][buy][time] != Integer.MIN_VALUE) return dp[idx][buy][time];
        if(time == 2) return 0;
        if(buy == 1) {
            int x = -prices[idx] + solve(idx + 1, 0, time, prices, dp);
            int y = solve(idx + 1, 1, time, prices, dp);
            dp[idx][buy][time] = Math.max(x, y);
        } else {
            int x = prices[idx] + solve(idx + 1, 1, time + 1, prices, dp);
            int y = solve(idx + 1, 0, time, prices, dp);
            dp[idx][buy][time] = Math.max(x, y);
        }
        return dp[idx][buy][time];
    }
}