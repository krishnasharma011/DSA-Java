class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<ArrayList<Integer>> q=new ArrayDeque<>();
        int[][] visited=new int[m][n];
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new ArrayList<>(Arrays.asList(i, j, 0)));
                    visited[i][j]=2;
                }
                else if(grid[i][j]==1) fresh++;
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            ArrayList<Integer> li=q.poll();
            int r=li.get(0);
            int c=li.get(1);
            int t=li.get(2);
            ans=Math.max(ans,t);
            if(r - 1 >= 0 && grid[r-1][c] == 1 && visited[r-1][c] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r-1, c, t+1)));
                visited[r-1][c] = 2;
                fresh--;
            }
            if(c - 1 >= 0 && grid[r][c-1] == 1 && visited[r][c-1] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r, c-1, t+1)));
                visited[r][c-1] = 2;
                fresh--;
            }
            if(r + 1 < m && grid[r+1][c] == 1 && visited[r+1][c] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r+1, c, t+1)));
                visited[r+1][c] = 2;
                fresh--;
            }
            if(c + 1 < n && grid[r][c+1] == 1 && visited[r][c+1] == 0) {
                q.add(new ArrayList<>(Arrays.asList(r, c+1, t+1)));
                visited[r][c+1] = 2;
                fresh--;
            }
        } 
        if(fresh > 0) return -1;
        return ans;
    }
}