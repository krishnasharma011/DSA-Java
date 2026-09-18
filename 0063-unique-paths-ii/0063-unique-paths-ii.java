class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
        return solve(obstacleGrid,0,0,m,n,dp);
    }

    private int solve(int[][] grid,int i,int j,int m,int n,int[][] dp){
        if(i==(m-1) && j==(n-1)){
            return 1;
        }
        if(i==m || j==n || grid[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        dp[i][j]=solve(grid,i+1,j,m,n,dp)+solve(grid,i,j+1,m,n,dp);
        return dp[i][j]; 
    }
}
