class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        for(double[][] arr: dp) {
            for(double[] temp : arr) {
                Arrays.fill(temp , -1.0);
            }
        }
        double ans = solve(row, column, k, n, dp);
        return ans;
    }

    private double solve(int r, int c, int k, int n, double[][][] dp) {
        if(r <= -1 || c <= -1 || r >= n || c >= n) 
            return 0.0;
        if(k == 0) 
            return 1.0;
        if(dp[r][c][k] != -1.0) 
            return dp[r][c][k];
        int[] x = new int[] {-2,-2,-1,-1,1,1,2,2};
        int[] y = new int[] {-1,1,-2,2,-2,2,-1,1};
        double ans = 0.0;
        for(int i = 0; i < x.length; i++) {
            ans += (1.0/8) * solve(r + x[i], c + y[i], k-1, n, dp);
        }
        return dp[r][c][k] = ans;
    }
}