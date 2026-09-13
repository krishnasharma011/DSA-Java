class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        } 
        int[] indegree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int v=prerequisites[i][0];
            int u=prerequisites[i][1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q=new ArrayDeque<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int f=q.poll();
            ans.add(f);
            for(int ngr:adj.get(f)){
                indegree[ngr]--;
                if(indegree[ngr]==0) q.add(ngr);
            }
        }
        return ans.size()==numCourses;
    }   
}