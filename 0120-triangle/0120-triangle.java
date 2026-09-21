class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer[][] dp = new Integer[n][];
        for(int i=0;i<n;i++){
            dp[i]=new Integer[triangle.get(i).size()];
        }
        return solve(triangle,0,0,dp);
    }

    private int solve(List<List<Integer>> triangle,int row,int col,Integer[][] dp){
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col]!=null){
            return dp[row][col];
        } 
        dp[row][col]=triangle.get(row).get(col) + 
        Math.min(solve(triangle,row+1,col,dp),solve(triangle,row+1,col+1,dp));
        return dp[row][col];
    }
}