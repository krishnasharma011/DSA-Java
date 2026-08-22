class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }

    private int atmost(int[] nums,int k){
        int n=nums.length;
        int left=0;
        int right=0;
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(right<n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                int freq=map.get(nums[left]);
                map.put(nums[left],map.get(nums[left])-1);
                freq--;
                if(freq == 0){
                    map.remove(nums[left]);
                }
                left++;
            } 
            count+=right-left+1;
            right++;
        }
        return count;
    }
}