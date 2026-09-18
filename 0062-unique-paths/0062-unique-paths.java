class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        dp[n-1]=1;
        for(int i=1;i<=m;i++){
            for(int j=n-2;j>=0;j--){
                dp[j]=dp[j]+dp[j+1];
            }
        }
        return dp[0];
    }
}