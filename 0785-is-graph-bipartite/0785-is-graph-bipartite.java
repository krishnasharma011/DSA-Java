class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!(dfs(graph,i,0,color))){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph,int s,int curr,int[] color){
        color[s]=curr;
        for(int ngr:graph[s]){
            if(color[ngr]==-1){
                if(!(dfs(graph,ngr,1-curr,color))){
                    return false;
                }
            }
            else if(color[ngr]==curr) return false;
        }
        return true;
    }
}