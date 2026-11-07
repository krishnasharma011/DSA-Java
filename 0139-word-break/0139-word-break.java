class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        // Arrays.fill(dp, null);
        dp[n] = true;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j <= n; j++) {
                String temp = s.substring(i,j);
                if(wordDict.contains(temp)){
                    if(dp[j] == true) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];

        // return solve(0, s, wordDict, dp);
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