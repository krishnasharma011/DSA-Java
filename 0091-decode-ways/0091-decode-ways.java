class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0,s,dp);
    }

    private int solve (int idx, String s,int[] dp) {
        if(idx == s.length()) return 1;
        if(s.charAt(idx) == '0') return 0;
        if(dp[idx] != -1) return dp[idx];
        int one = solve(idx + 1, s, dp);
        int two = 0;
        if(idx + 2 <= s.length()){
            String temp = s.substring(idx,idx + 2);
            int t = Integer.valueOf(temp);
            if(t <= 26) {
                two = solve(idx + 2, s, dp);
            }
        }
        return dp[idx] = one + two;
    }
}