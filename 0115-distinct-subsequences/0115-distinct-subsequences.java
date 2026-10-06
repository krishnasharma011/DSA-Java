class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m>n) return 0;
        if(m==n && s.equals(t)) return 1;
        if(m==n) return 0;
        int[][] dp=new int[n+1][m+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,n,m,s,t,dp);
    }

    private int solve(int i,int j,int n,int m,String s,String t,int[][] dp){
        if(j>=m) return 1;
        if(i>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            int skip=solve(i+1,j,n,m,s,t,dp);
            int pick=solve(i+1,j+1,n,m,s,t,dp);
            return dp[i][j]=pick+skip;
        }
        return dp[i][j]=solve(i+1,j,n,m,s,t,dp);
    }
}