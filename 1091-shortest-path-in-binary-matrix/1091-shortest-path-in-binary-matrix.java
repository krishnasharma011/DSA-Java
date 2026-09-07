class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    visited[i][j]=1;
                }
            }
        }
        
        Queue<ArrayList<Integer>> q=new ArrayDeque<>();
        q.add(new ArrayList<>(Arrays.asList(0,0,1)));
        while(!q.isEmpty()){
            ArrayList<Integer> li=q.poll();
            int r=li.get(0);
            int c=li.get(1);
            int l=li.get(2);
            if(r==(m-1) && c==(n-1)) return l;
            if(r-1 >= 0 && grid[r-1][c] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r-1, c, l+1)));
                grid[r-1][c] = 1;
            }
            if(r+1 < m && grid[r+1][c] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r+1, c, l+1)));
                grid[r+1][c] = 1;
            }
            if(c-1 >= 0 && grid[r][c-1] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r, c-1, l+1)));
                grid[r][c-1] = 1;
            }
            if(c+1 < n && grid[r][c+1] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r, c+1, l+1)));
                grid[r][c+1] = 1;
            }
            if(r-1 >= 0 && c-1 >= 0 && grid[r-1][c-1] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r-1, c-1, l+1)));
                grid[r-1][c-1] = 1;
            }
            if(r-1 >= 0 && c+1 < n && grid[r-1][c+1] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r-1, c+1, l+1)));
                grid[r-1][c+1] = 1;
            }
            if(r+1 < m && c-1 >= 0 && grid[r+1][c-1] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r+1, c-1, l+1)));
                grid[r+1][c-1] = 1;
            }
            if(r+1 < m && c+1 < n && grid[r+1][c+1] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r+1, c+1, l+1)));
                grid[r+1][c+1] = 1;
            }
        }
        return -1;
    }
}