class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        Arrays.fill(dp, null);
        return solve(0, s, wordDict, dp);
    }

    private boolean solve(int idx, String s, List<String> li, Boolean[] dp) {
        if (idx == s.length())
            return true;
        if(dp[idx] != null) return dp[idx];
        for (int j = idx + 1; j <= s.length(); j++) {
            String temp = s.substring(idx, j);
            if (li.contains(temp)) {
                if (solve(j, s, li, dp) == true)
                    return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}