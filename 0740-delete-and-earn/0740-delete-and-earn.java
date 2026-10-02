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
        Arrays.fill(dp,-1);
        int ans=solve(0,freq,dp);
        return ans;
    }

    private int solve(int idx,int[] freq,int[] dp) {
        if(idx>=freq.length){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int skip=solve(idx+1,freq,dp);
        int pick=solve(idx+2,freq,dp)+(idx*freq[idx]);
        return dp[idx]=Math.max(skip,pick);
    }
}