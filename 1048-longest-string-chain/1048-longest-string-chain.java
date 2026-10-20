class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 > dp[i] && isPossible(words[i], words[j])) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    private boolean isPossible(String a, String b) {
        if (a.length() != b.length() + 1)
            return false;
        int i=0;
        int j=0;
        while(i < a.length()){
            if(j<b.length() && a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            } else {
                i++;
            }
        }
        if(i==a.length() && j == b.length())
            return true;
        return false;
    }
}