class Solution {
    public int totalNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        return NQueens(n,0,board);
    }

    private int NQueens(int n,int tq,boolean[][] board){
        if(tq==n){
            return 1;
        }
        int count=0;
        for(int col=0;col<n;col++){
            if(isSafe(tq,col,board)){
                board[tq][col]=true;
                count+= NQueens(n,tq+1,board);
                board[tq][col]=false;
            }
        }
        return count;
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
}