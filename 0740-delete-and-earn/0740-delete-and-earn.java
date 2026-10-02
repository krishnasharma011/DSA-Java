class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int[] freq=new int[max+1];
        for(int val:nums){
            freq[val]++;
        }
        int[] dp=new int[max+1];
        
        dp[0]=0;
        dp[1]=freq[1];
        for(int i=2;i<freq.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+(i*freq[i]));
        }
        return dp[max];
    }
}