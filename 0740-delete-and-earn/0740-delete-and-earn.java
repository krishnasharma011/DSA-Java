class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int val : nums) {
            max = Math.max(val, max);
        }
        int[] freq = new int[max + 1];
        for (int val : nums) {
            freq[val]++;
        }
        int[] dp = new int[max + 1];

        dp[max] = max * freq[max];
        dp[max - 1] = Math.max((max - 1) * freq[max - 1], dp[max]);
        for (int i = max - 2; i >= 0; i--) {
            int skip = dp[i + 1];
            int pick = i * freq[i] + dp[i + 2];
            dp[i] = Math.max(skip, pick);
        }
        return dp[0];

        // Arrays.fill(dp, -1);
        // int ans = solve(0, freq, dp);
        // return ans;
    }

    private int solve(int idx, int[] freq, int[] dp) {
        if (idx >= freq.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];
        int skip = solve(idx + 1, freq, dp);
        int pick = idx * freq[idx] + solve(idx + 2, freq, dp);
        return dp[idx] = Math.max(pick, skip);
    }
}