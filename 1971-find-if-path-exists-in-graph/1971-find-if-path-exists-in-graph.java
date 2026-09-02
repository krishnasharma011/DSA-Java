class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=createAdjList(n,edges);
        boolean[] visited=new boolean[n];
        return dfsHelper(adj,source,visited,destination);
    }

    private boolean dfsHelper(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited,int d){
        visited[s]=true;
        if(d == s) {
            return true;
        }
        for(int ngr:adj.get(s)){
            if(!visited[ngr]){
                if(dfsHelper(adj,ngr,visited,d)){
                    return true;
                }
            }
        }
        return false;
    }

    private ArrayList<ArrayList<Integer>> createAdjList(int n,int[][] edges){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }   
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}