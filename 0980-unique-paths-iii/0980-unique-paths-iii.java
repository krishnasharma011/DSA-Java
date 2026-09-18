class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];
        int ans=0;
        int remian=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    remian++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans=solve(grid,m,n,i,j,visited,remian);
                    break;
                }
            }
        }
        return ans;
    }

    private int solve(int[][] grid,int m,int n,int i,int j,int[][] visited,int remianing){
        if(i<0 || j<0 || i==m || j==n || grid[i][j]==-1 || visited[i][j]==1) return 0;
        if(grid[i][j]==0) remianing--;
        if(grid[i][j]==2 && remianing==0) return 1;
        visited[i][j]=1;
        int l=solve(grid,m,n,i,j-1,visited,remianing);
        int u=solve(grid,m,n,i-1,j,visited,remianing);
        int r=solve(grid,m,n,i,j+1,visited,remianing);
        int d=solve(grid,m,n,i+1,j,visited,remianing);
        visited[i][j]=0;
        return l+u+r+d;
    }
}