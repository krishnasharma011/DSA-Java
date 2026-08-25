class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int i=0;
        subSets(nums,ans,new ArrayList<>(),i);
        return ans;
    }

    private void subSets(int[] nums, List<List<Integer>> ans, List<Integer> curr, int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        curr.add(nums[i]);
        subSets(nums,ans,curr,i+1);
        curr.remove(curr.size()-1);
        subSets(nums,ans,curr,i+1);
    }
}