class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        int max=-1;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        if(k==n) return max;
        HashMap<Integer,Integer> map=new HashMap<>();
        max=-1;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<n;i++){
            int temp=map.get(nums[i]);
            if(temp==1) max=Math.max(max,nums[i]);
        }
        if(k==1) return max;
        int ans=-1;
        int a=nums[0];
        int b=nums[n-1];
        if(map.get(a)==1){
            ans= Math.max(ans,a);
        }
        if(map.get(b)==1){
            ans= Math.max(ans,b);
        }
        return ans;
    }
}