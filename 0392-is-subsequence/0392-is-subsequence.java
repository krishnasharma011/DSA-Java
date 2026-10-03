class Solution {
    public boolean isSubsequence(String s, String t) {
        Boolean[][] dp=new Boolean[s.length()][t.length()];
        return solve(0,0,s,t,dp);
    }

    private boolean solve(int i,int j,String s, String t,Boolean[][] dp) {
        if(i==s.length()) return true;
        if(j==t.length()) return false;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= solve(i+1,j+1,s,t,dp);
        }
        else return dp[i][j]= solve(i,j+1,s,t,dp);
    }
}