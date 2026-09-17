class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        } 
        for(int i=0;i<prerequisites.length;i++){
            int v=prerequisites[i][0];
            int u=prerequisites[i][1];
            adj.get(u).add(v);
        }
        int[] state=new int[numCourses];
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(state[i]==0){
                if(dfs(adj,i,state,li)){
                    return new int[0];
                }
            }
        }
        if(li.size()!=numCourses) return new int[0];
        int[] ans=new int[li.size()];
        int j=li.size()-1;
        for(int i=0;i<ans.length;i++){
            ans[i]=li.get(j--);
        }
        return ans;
    }

    private boolean dfs(List<List<Integer>> adj,int s,int[] state,List<Integer> li){
        state[s]=1;
        for(int ngr:adj.get(s)){
            if(state[ngr]==0){
                if(dfs(adj,ngr,state,li)){
                    return true;
                }
            }
            else if(state[ngr]==1) return true;
        }
        state[s]=2;
        li.add(s);
        return false;
    }
}