class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        Queue<List<Integer>> q=new ArrayDeque<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new ArrayList<>(Arrays.asList(i,j,0)));
                    visited[i][j]=true;
                } 
                else if(grid[i][j]==1) fresh++;
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            List<Integer> front=q.poll();
            int r=front.get(0);
            int c=front.get(1);
            int t=front.get(2);
            ans=Math.max(ans,t);
            if(r-1>=0 && !visited[r-1][c] && grid[r-1][c]==1){
                q.offer(new ArrayList<>(Arrays.asList(r-1,c,t+1)));
                visited[r-1][c]=true;
                fresh--;
            }
            if(c - 1 >= 0 && grid[r][c-1] == 1 && !visited[r][c-1]) {
                q.add(new ArrayList<>(Arrays.asList(r, c-1, t+1)));
                visited[r][c-1] = true;
                fresh--;
            }
            if(r + 1 < m && grid[r+1][c] == 1 && !visited[r+1][c]) {
                q.add(new ArrayList<>(Arrays.asList(r+1, c, t+1)));
                visited[r+1][c] = true;
                fresh--;
            }
            if(c + 1 < n && grid[r][c+1] == 1 && !visited[r][c+1]) {
                q.add(new ArrayList<>(Arrays.asList(r, c+1, t+1)));
                visited[r][c+1] = true;
                fresh--;
            }
        }
        if(fresh>0) return -1;
        return ans;
    }
}