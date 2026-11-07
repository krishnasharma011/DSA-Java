class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int max = days[n - 1];
        int[] nums = new int[max + 1];
        for (int i = 0; i < n; i++) {
            nums[days[i]] = 1;
        }
        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);
        int ans = solve(1, nums, costs, dp);
        return ans;
    }

    private int solve(int idx, int[] nums, int[] costs, int[] dp) {
        if (idx >= nums.length)
            return 0;
        if(dp[idx] != -1) return dp[idx];
        int one_pass = Integer.MAX_VALUE;
        int seven_pass = Integer.MAX_VALUE;
        int thirty_pass = Integer.MAX_VALUE;
        if(nums[idx] == 0) {
            dp[idx] = solve(idx + 1, nums, costs, dp);
        } else {
            one_pass = costs[0] + solve(idx + 1, nums, costs, dp);
            seven_pass = costs[1] + solve(idx + 7, nums, costs, dp);
            thirty_pass = costs[2] + solve(idx + 30, nums, costs, dp);
            dp[idx] = Math.min(one_pass, Math.min(seven_pass, thirty_pass));
        }
        return dp[idx];
    }
}