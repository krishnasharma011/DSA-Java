class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size();
        int n = board.get(0).length();
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            String temp = board.get(i);
            for (int j = 0; j < n; j++) {
                char ch = temp.charAt(j);
                arr[i][j] = ch;
            }
        }
        int[] ans = new int[] { 0, 0 };
        int[][] dp = new int[m][n];
        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        ans[0] = maxScore(m - 1, n - 1, arr, dp);
        if (ans[0] == Integer.MIN_VALUE)
            return new int[] { 0, 0 };
        int[][][] dp2 = new int[m][n][ans[0] + 1];
        for (int[][] ar : dp2) {
            for (int[] temp : ar) {
                Arrays.fill(temp, -1);
            }
        }
        ans[1] = paths(m - 1, n - 1, arr, dp2, ans[0]);
        return ans;
    }

    private int paths(int m, int n, char[][] arr, int[][][] dp, int target) {
        if (m < 0 || n < 0 || target < 0)
            return 0;
        if (m == 0 && n == 0 && target == 0)
            return 1;
        if (arr[m][n] == 'X')
            return 0;
        if (dp[m][n][target] != -1)
            return dp[m][n][target];
        int left = 0;
        if (arr[m][n] != 'S') {
            int num = arr[m][n] - '0';
            left = paths(m, n - 1, arr, dp, target - num);
        } else {
            left = paths(m, n - 1, arr, dp, target);
        }
        int top_left = 0;
        if (arr[m][n] != 'S') {
            int num = arr[m][n] - '0';
            top_left = paths(m - 1, n - 1, arr, dp, target - num);
        } else {
            top_left = paths(m - 1, n - 1, arr, dp, target);
        }
        int up = 0;
        if (arr[m][n] != 'S') {
            int num = arr[m][n] - '0';
            up = paths(m - 1, n, arr, dp, target - num);
        } else {
            up = paths(m - 1, n, arr, dp, target);
        }
        return dp[m][n][target] = (int) (((long) left + up + top_left) % 1_000_000_007);
    }

    private int maxScore(int m, int n, char[][] arr, int[][] dp) {
        if (m < 0 || n < 0)
            return Integer.MIN_VALUE;
        if (m == 0 && n == 0)
            return 0;
        if (arr[m][n] == 'X')
            return Integer.MIN_VALUE;
        if (dp[m][n] != -1)
            return dp[m][n];
        int left = 0;
        if (arr[m][n] != 'S') {
            int num = arr[m][n] - '0';
            int temp = maxScore(m, n - 1, arr, dp);
            if (temp != Integer.MIN_VALUE)
                left = num + temp;
            else
                left = Integer.MIN_VALUE;
        } else {
            left = maxScore(m, n - 1, arr, dp);
        }
        int top_left = 0;
        if (arr[m][n] != 'S') {
            int num = arr[m][n] - '0';
            int temp = maxScore(m - 1, n - 1, arr, dp);
            if (temp != Integer.MIN_VALUE)
                top_left = num + temp;
            else
                top_left = Integer.MIN_VALUE;
        } else {
            top_left = maxScore(m - 1, n - 1, arr, dp);
        }
        int up = 0;
        if (arr[m][n] != 'S') {
            int num = arr[m][n] - '0';
            int temp = maxScore(m - 1, n, arr, dp);
            if (temp != Integer.MIN_VALUE)
                up = num + temp;
            else
                up = Integer.MIN_VALUE;
        } else {
            up = maxScore(m - 1, n, arr, dp);
        }
        return dp[m][n] = Math.max(left, Math.max(up, top_left));
    }
}