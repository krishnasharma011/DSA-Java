class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        List<Integer> li = new ArrayList<>();
        li.add(envelopes[0][1]);
        for (int i=1;i<n;i++) {
            int temp = envelopes[i][1];
            if(temp>li.get(li.size()-1)){
                li.add(temp);
                ans++;
            }
            else {
                int idx = lowerBound(li, temp);
                li.set(idx,temp);
            }
        }
        return ans;
    }

    private int lowerBound(List<Integer> tails, int target) {
        int low = 0, high = tails.size();
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (tails.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}