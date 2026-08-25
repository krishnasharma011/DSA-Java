class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
                max=Math.max(max,nums[i]);
            } 
        }
        for(int i=k;i<=max;i+=k){
            if(!set.contains(i)) return i;
        }
        return max+k;
    }
}