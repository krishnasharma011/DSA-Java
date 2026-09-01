class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        combinationSumII(candidates,target,0,ans,new ArrayList<>(),0);
        return ans;
    }

    private void combinationSumII(int[] nums, int target,int idx,List<List<Integer>> li,List<Integer> curr,int sum){
        if(sum==target){
            li.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target || idx==nums.length) return; 
        curr.add(nums[idx]);
        combinationSumII(nums,target,idx+1,li,curr,sum+nums[idx]);
        curr.remove(curr.size()-1);
        while(idx+1<nums.length && nums[idx+1]==nums[idx]){
            idx++;
        }
        combinationSumII(nums,target,idx+1,li,curr,sum);
    }
}