class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        boolean[][] visited=new boolean[n][n];
        Queue<List<Integer>> q=new ArrayDeque<>();
        int temp=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new ArrayList<>(Arrays.asList(i,j,0)));
                    visited[i][j]=true;
                    temp++;
                }
            }
        }
        if(temp==0 || temp==n*n) return -1;
        int ans=0;
        while(!q.isEmpty()){
            List<Integer> li=q.poll();
            int r=li.get(0);
            int c=li.get(1);
            int t=li.get(2);
            ans=Math.max(ans,t);
            if(r-1>=0 && !visited[r-1][c] && grid[r-1][c]==0){
                q.add(new ArrayList<>(Arrays.asList(r-1,c,t+1)));
                visited[r-1][c]=true;
            }
            if(c-1>=0 && !visited[r][c-1] && grid[r][c-1]==0){
                q.add(new ArrayList<>(Arrays.asList(r,c-1,t+1)));
                visited[r][c-1]=true;
            }
            if(r+1<n && !visited[r+1][c] && grid[r+1][c]==0){
                q.add(new ArrayList<>(Arrays.asList(r+1,c,t+1)));
                visited[r+1][c]=true;
            }
            if(c+1<n && !visited[r][c+1] && grid[r][c+1]==0){
                q.add(new ArrayList<>(Arrays.asList(r,c+1,t+1)));
                visited[r][c+1]=true;
            }
        }
        return ans;
    }
}