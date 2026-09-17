class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(v).add(u);
        }
        int[] state=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(state[i] == 0){
                if(dfs(adj,i,state)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj,int s,int[] state){
        state[s]=1;
        for(int ngr:adj.get(s)){
            if(state[ngr]==0){
                if(dfs(adj,ngr,state)){
                    return true;
                }
            }
            else if(state[ngr]==1) return true;
        }
        state[s]=2;
        return false;
    }
}