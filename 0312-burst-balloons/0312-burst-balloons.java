class Solution {
    int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        dp = new int[n + 1][n + 1];
        for(int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return solve(1, n, arr);
    }

    private int solve(int i, int j, int[] nums) {
        if (i > j)
            return 0;
        if (i == j)
            return nums[i - 1] * nums[i] * nums[j + 1];
        if (dp[i][j] != -1)
            return dp[i][j];
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = nums[i - 1] * nums[k] * nums[j + 1];
            int l = solve(i, k - 1, nums);
            int r = solve(k + 1, j, nums);
            max = Math.max(max, cost + l + r);
        }
        return dp[i][j] = max;
    }
}