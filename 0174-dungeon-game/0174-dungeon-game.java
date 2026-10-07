class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        if(m == 1 && n == 1){
            if(dungeon[0][0] > 0) return 1;
            else return 1 - dungeon[0][0];
        }
        int[][] dp = new int[m][n];
        for(int[] arr:dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, 0, m, n, dungeon, dp);
    }

    private int solve(int i, int j, int m, int n, int[][] dungeon, int[][] dp) {
        if(i == m || j == n) return Integer.MAX_VALUE;
        if(i == (m-1) && j == (n-1)){
            if(dungeon[i][j] >= 0) return 1;
            else return 1 - dungeon[i][j];
        } 
        if(dp[i][j] != -1) return dp[i][j];
        int d = solve(i+1, j, m, n, dungeon, dp);
        int r = solve(i, j+1, m, n, dungeon, dp);
        if(dungeon[i][j] >= Math.min(d, r)) return dp[i][j] = 1;
        else return dp[i][j] = Math.min(d, r) - dungeon[i][j];
    }
}

        // int h=0;
        // if(dungeon[m-1][n-1]<0){
        //     dp[m-1][n-1]=1-dungeon[m-1][n-1];
        //     h=dp[m-1][n-1];
        // } 
        // for(int i=n-2;i>=0;i--){
        //     for(int j=n-2;j>=0;j--){

        //     }
        // }