class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int right=0;
        int ans=0;
        int temp=0;
        while(right<n){
            if(nums[right]==0) temp++;
            if(temp>k){
                if(nums[left]==0) temp--;
                left++;
            }    
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}