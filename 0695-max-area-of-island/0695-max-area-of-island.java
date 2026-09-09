class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    ans=Math.max(ans,dfs(grid,i,j,visited));
                }
            }
        }
        return ans;
    }
    
    private int dfs(int[][] grid,int i,int j,boolean[][] visited){
        visited[i][j]=true;
        int left=0;
        int right=0;
        int down=0;
        int up=0;
        if(i-1>=0 && !visited[i-1][j] && grid[i-1][j]==1){
            up=dfs(grid,i-1,j,visited);
        }
        if(j-1>=0 && !visited[i][j-1] && grid[i][j-1]==1){
            left=dfs(grid,i,j-1,visited);
        }
        if(i+1<grid.length && !visited[i+1][j] && grid[i+1][j]==1){
            down=dfs(grid,i+1,j,visited);
        }
        if(j+1<grid[0].length && !visited[i][j+1] && grid[i][j+1]==1){
            right=dfs(grid,i,j+1,visited);
        }
        return 1+left+right+down+up;
    }
}