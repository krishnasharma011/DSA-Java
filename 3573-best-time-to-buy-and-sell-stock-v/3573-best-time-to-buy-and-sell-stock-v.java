class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n][2][2 * k];
        for (long[][] arr : dp) {
            for (long[] temp : arr) {
                Arrays.fill(temp, -1);
            }
        }
        // long a = solve(prices, 0, 1, 2 * k, dp);
        // long b = solve(prices, 0, 0, 2 * k, dp);
        // return Math.max(a, b);

        return solve(prices, 0, 1, 2 * k -1 , dp);      
        //  by passing the first sell fn in this ...
    }

    private long solve(int[] prices, int i, int buy, int k, long[][][] dp) {
        if (k == -1) return 0;

        if (i == prices.length) {
            if (buy == 1 && (k % 2 == 0)) return Integer.MIN_VALUE;
            else return 0;
        }

        if(dp[i][buy][k] != -1) return dp[i][buy][k];

        if (buy == 0  && (k % 2 == 0)){
            long a = prices[i] + solve(prices, i + 1, 1, k-1, dp);
            long b = solve(prices, i + 1, 0, k, dp);
            return dp[i][buy][k] = Math.max(a, b);
        }
        
        if (buy == 1 && (k % 2 == 1)) {
            long a = -prices[i] + solve(prices, i + 1, 0, k-1, dp);
            long b = prices[i] + solve(prices, i + 1, 1, k-1, dp);
            long c = solve(prices, i + 1, 1, k, dp);
            return dp[i][buy][k] = Math.max(a, Math.max(b, c));
        }
        
        else {
            long a = -prices[i] + solve(prices, i + 1, 1, k-1, dp);
            long b = solve(prices, i + 1, 1, k, dp);
            return dp[i][buy][k] = Math.max(a, b);
        }
    }
}