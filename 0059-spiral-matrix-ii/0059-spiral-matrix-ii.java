class Solution {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int sr = 0;
        int sc = 0;
        int er = n - 1;
        int ec = n - 1;
        int num = 1;
        while (num <= n * n) {
            int i = sc;
            while (i <= ec) {
                ans[sr][i] = num++;
                i++;
            }
            sr++;
            i = sr;
            while (i <= er) {
                ans[i][ec] = num++;
                i++;
            }
            ec--;
            if (sr <= er) {
                i = ec;
                while (i >= sc) {
                    ans[er][i] = num++;
                    i--;
                }
                er--;
            }
            if (sc <= ec) {
                i = er;
                while (i >= sr) {
                    ans[i][sc] = num++;
                    i--;
                }
                sc++;
            }
        }
        return ans;
    }
}