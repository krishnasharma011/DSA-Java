class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int val : stones) {
            sum += val;
        }
        int s = sum / 2;
        int[][] dp = new int[n][s + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = solve(0, s, stones, dp);
        return sum - 2 * ans;
    }

    private int solve(int idx, int target, int[] stones, int[][] dp) {
        if (idx == stones.length)
            return 0;
        if (target <= 0)
            return 0;
        if (dp[idx][target] != -1)
            return dp[idx][target];
        int skip = solve(idx + 1, target, stones, dp);
        int pick = 0;
        if (stones[idx] <= target) {
            pick = stones[idx] + solve(idx + 1, target - stones[idx], stones, dp);
        }
        return dp[idx][target] = Math.max(pick, skip);
    }
}