class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        Arrays.sort(nums);
        if(n == 2){
            return nums[1]-nums[0];
        }
        int mid = nums[(n-1)/2];
        int ans = 0;
        for (int k = 0; k < n; k++) {
            ans += Math.abs(nums[k] - mid);
        }
        return ans;
    }
}