class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]+=max;
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }


    // public int lengthOfLIS(int[] nums) {
    //     int n=nums.length;
    //     Integer[][] dp=new Integer[n][n];
    //     return solve(0,-1,nums,dp);
    // }

    // private int solve(int idx,int prevIdx,int[] nums,Integer[][] dp){
    //     if(idx==nums.length) return 0;
    //     if(dp[idx][prevIdx+1]!=null) return dp[idx][prevIdx+1];
    //     int skip=solve(idx+1,prevIdx,nums,dp);
    //     if(prevIdx>=0 && nums[idx]<=nums[prevIdx]) return dp[idx][prevIdx+1]=skip;
    //     int pick=1+solve(idx+1,idx,nums,dp);
    //     return dp[idx][prevIdx+1]=Math.max(skip,pick);
    // }
}