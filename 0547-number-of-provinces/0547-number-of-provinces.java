class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }

    private void bfs(int[][] matrix,int s,boolean[] visited){
        int n=matrix.length;
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(s);
        visited[s]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int j=0;j<n;j++){
                if(matrix[curr][j]==1 && !visited[j]){
                    q.offer(j);
                    visited[j]=true;
                }
            }
        }
    }
}