class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i,j,grid,visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int i,int j,char[][] grid,boolean[][] visited){
        int m=grid.length;
        int n=grid[0].length;
        visited[i][j]=true;
        if(i-1>=0 && !visited[i-1][j] && grid[i-1][j]=='1') dfs(i-1,j,grid,visited);
        if(j-1>=0 && !visited[i][j-1] && grid[i][j-1]=='1') dfs(i,j-1,grid,visited);
        if(i+1<m && !visited[i+1][j] && grid[i+1][j]=='1') dfs(i+1,j,grid,visited);
        if(j+1<n && !visited[i][j+1] && grid[i][j+1]=='1') dfs(i,j+1,grid,visited);
    }
}