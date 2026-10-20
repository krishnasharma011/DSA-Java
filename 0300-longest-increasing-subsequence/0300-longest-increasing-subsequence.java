class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> li = new ArrayList<>();
        int len = 1;
        li.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > li.get(li.size() - 1)) {
                li.add(nums[i]);
                len++;
            } else {
                int idx = lowerBound(li, nums[i]);
                li.set(idx, nums[i]);
            }
        }
        return len;
    }

    private int lowerBound(List<Integer> li, int target) {
        int low = 0;
        int high = li.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (li.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}