class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp = new int[n][m];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans=solve(n-1,m-1,word1,word2,dp);
        return ans;
    }

    private int solve(int n,int m,String word1,String word2,int[][] dp) {
        if(n==-1) return m+1;
        if(m==-1) return n+1;
        if(dp[n][m]!=-1) return dp[n][m];
        if(word1.charAt(n)==word2.charAt(m)){
            return dp[n][m]=solve(n-1,m-1,word1,word2,dp);
        }
        else {
            return dp[n][m]=1+Math.min(solve(n-1,m,word1,word2,dp),Math.min(solve(n,m-1,word1,word2,dp),solve(n-1,m-1,word1,word2,dp)));
        }
    }
}