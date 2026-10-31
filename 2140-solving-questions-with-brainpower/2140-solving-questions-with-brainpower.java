class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp,-1);
        long ans = solve(0, questions, dp);
        return ans;
    }

    private long solve (int idx, int[][] questions, long[] dp) {
        if(idx >= questions.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        long x = questions[idx][0] + solve(idx + 1 + questions[idx][1], questions, dp);
        long y = solve(idx + 1, questions, dp);
        long ans = Math.max(x, y);
        return dp[idx] = ans;
    }
}