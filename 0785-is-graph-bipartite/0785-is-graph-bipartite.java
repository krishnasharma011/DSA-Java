class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1) {
                if(!bfs(graph,i,color)) return false;
            }
        }
        return true;
    }

    private boolean bfs(int[][] adj,int s,int[] color){
        color[s]=0;
        Queue<Integer> q=new ArrayDeque<>();
        q.add(s);
        while(!q.isEmpty()){
            int front=q.poll();
            int colour=color[front];
            for(int ele:adj[front]){
                if(color[ele]==color[front]) return false;
                if(color[ele]==-1){
                    color[ele]=1-color[front];
                    q.add(ele);
                }
            }
        }
        return true;
    }
}