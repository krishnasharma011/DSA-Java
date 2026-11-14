class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m + 1][n + 1];
        for(int[][] ar : dp) {
            for(int[] arr : ar){
                Arrays.fill(arr, -1);
            }
        }
        return solve(0, strs, m, n, dp);
    }

    private int solve(int idx, String[] strs, int m, int n, int[][][] dp) {
        if(idx == strs.length) return 0;
        if(m < 0 || n < 0) return 0;
        if(dp[idx][m][n] != -1) return dp[idx][m][n];
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0; i < strs[idx].length(); i++) {
            if(strs[idx].charAt(i) == '0') zeroCount++;
            else oneCount++;
        }
        int skip = solve(idx + 1, strs, m, n, dp);
        int pick = 0;
        if(m - zeroCount >= 0 && n - oneCount >= 0) {
            pick = 1 + solve(idx + 1,strs, m - zeroCount, n - oneCount, dp);
        }
        return dp[idx][m][n] = Math.max(pick, skip);
    }
}