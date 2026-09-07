class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans=new int[m][n];
        Queue<ArrayList<Integer>> q=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) q.add(new ArrayList<>(Arrays.asList(i,j,0)));
            }
        }

        while(!q.isEmpty()){
            ArrayList<Integer> li=q.poll();
            int r=li.get(0);
            int c=li.get(1);
            int l=li.get(2);
            ans[r][c]=l;
            if(r-1>=0 && ans[r-1][c]==0 && mat[r-1][c]==1){
                ans[r-1][c]=l+1;
                q.add(new ArrayList<>(Arrays.asList(r-1,c,l+1)));
            }
            if(r+1<m && ans[r+1][c]==0 && mat[r+1][c]==1){
                ans[r+1][c]=l+1;
                q.add(new ArrayList<>(Arrays.asList(r+1,c,l+1)));
            }
            if(c-1>=0 && ans[r][c-1]==0 && mat[r][c-1]==1){
                ans[r][c-1]=l+1;
                q.add(new ArrayList<>(Arrays.asList(r,c-1,l+1)));
            }
            if(c+1<n && ans[r][c+1]==0 && mat[r][c+1]==1){
                ans[r][c+1]=l+1;
                q.add(new ArrayList<>(Arrays.asList(r,c+1,l+1)));
            }
        }

        return ans;
    }
}