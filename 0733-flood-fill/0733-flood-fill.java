class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited=new boolean[m][n];
        bfs(image,sr,sc,color,visited);
        return image;
    }

    private void bfs(int[][] image,int sr,int sc,int color,boolean[][] visited) {
        int m = image.length;
        int n = image[0].length;
        int colour=image[sr][sc];
        visited[sr][sc] = true;
        Queue<List<Integer>> q=new ArrayDeque<>();
        q.add(Arrays.asList(sr,sc));
        while(!q.isEmpty()){
            image[sr][sc]=color;
            List<Integer> l=q.poll();
            int srr=l.get(0);
            int scr=l.get(1);
            image[srr][scr]=color;
            if (srr-1>=0 && image[srr-1][scr] == colour && !visited[srr-1][scr]) {
                q.add(Arrays.asList(srr-1,scr));
                visited[srr-1][scr] = true;
            }
            if (srr+1<m && image[srr+1][scr]==colour && !visited[srr+1][scr]) {
                q.add(Arrays.asList(srr+1,scr));
                visited[srr+1][scr] = true;
            }
            if (scr-1>=0 && image[srr][scr-1]==colour && !visited[srr][scr-1]) {
                q.add(Arrays.asList(srr,scr-1));
                visited[srr][scr-1] = true;
            }
            if (scr+1<n && image[srr][scr+1]==colour && !visited[srr][scr+1]) {
                q.add(Arrays.asList(srr,scr+1));
                visited[srr][scr+1] = true;
            }
        }
    }
}