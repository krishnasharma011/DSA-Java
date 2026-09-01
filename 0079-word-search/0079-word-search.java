class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(search(board,word,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board,String word,int i,int j,int idx){
        int m=board.length;
        int n=board[0].length;
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!=word.charAt(idx)){
            return false ;
        }
        if(idx==word.length()-1) return true;
        board[i][j]='*';
        boolean right=search(board,word,i,j+1,idx+1);
        boolean down=search(board,word,i+1,j,idx+1);
        boolean up=search(board,word,i-1,j,idx+1);
        boolean left=search(board,word,i,j-1,idx+1);
        board[i][j]=word.charAt(idx);
        if(right || down || left || up){
            return true;
        }
        return false;
    }
}