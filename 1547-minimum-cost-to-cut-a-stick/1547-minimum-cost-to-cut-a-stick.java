class Solution {
    int max = Integer.MAX_VALUE;
    HashMap<String, Integer> memo;
    public int minCost(int n, int[] cuts) {
        memo = new HashMap<>();
        return solve(0, n, cuts);
    }

    private int solve(int s, int e, int[] cuts) {
        if (s == e) return 0;
        String key= s+"-"+e;
        if (memo.get(key) != null) return memo.get(key);
        int min = max;
        for (int i = 0; i < cuts.length; i++) {
            if(cuts[i] <= s || cuts[i] >= e) continue;
            int cost = e - s;
            int left = solve(s, cuts[i], cuts);
            int right = solve(cuts[i], e, cuts);
            if(left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) min = Math.min(min, cost);
            else if(left == Integer.MAX_VALUE) min = Math.min(min, right + cost);
            else if(right == Integer.MAX_VALUE) min = Math.min(min, left + cost);
            else min = Math.min(min, left + cost + right);
        }
        memo.put(key, min);
        return min;
    }
}