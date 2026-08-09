class Solution {
    public int splitArray(int[] nums, int k) {
        int sum=0;
        int max=0;
        for(int val:nums){
            sum+=val;
            max=Math.max(max,val);
        }
        int lo=max;
        int hi=sum;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(split(nums,mid)<=k){
                ans=mid;
                hi=mid-1;
            }
            else lo=mid+1;
        }
        return ans;
    }

    private int split(int[] nums,int mid){
        int t=1;
        int temp=mid;
        for(int val:nums){
            if(temp>=val){
                temp-=val;
            }
            else{
                t++;
                temp=mid-val;
            }
        }
        return t;
    }
}