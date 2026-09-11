class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        NQueens(n,0,ans,board);
        return ans;
    }

    private void NQueens(int n,int tq,List<List<String>> ans,boolean[][] board){
        if(tq==n){
            ans.add(display(board));
            return ;
        }
        for(int col=0;col<n;col++){
            if(isSafe(tq,col,board)){
                board[tq][col]=true;
                NQueens(n,tq+1,ans,board);
                board[tq][col]=false;
            }
        }
    }

    private boolean isSafe(int row,int col,boolean[][] board){
        int r=row;
        int c=col;
        while(r>=0){
            if(board[r][c]){
                return false;
            }
            r--;
        }
        r=row;
        while(r>=0 && c>=0){
            if(board[r][c]){
                return false;
            }
            r--;
            c--;
        }
        r=row;
        c=col;
        while(r>=0 && c<board.length){
            if(board[r][c]){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }

    private List<String> display(boolean[][] board){
        int n=board.length;
        List<String> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            String temp="";
            for(int j=0;j<n;j++){
                if(board[i][j]){
                    temp+="Q";
                }
                else temp+=".";
            }
            res.add(temp);
        }
        return res;
    }
}