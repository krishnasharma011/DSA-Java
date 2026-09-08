class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        Arrays.sort(nums);
        permutations(ans,li,0,nums);
        return ans;
    }

    private void permutations(List<List<Integer>> ans,List<Integer> curr,int idx,int[] nums){
        if(curr.size()==nums.length){
            if(!ans.contains(curr)) ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int i=0;i<curr.size()+1;i++){
            curr.add(i,nums[idx]);
            permutations(ans,curr,idx+1,nums);
            curr.remove(i);
        }
    }
}