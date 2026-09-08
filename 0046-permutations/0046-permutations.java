class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        permutations(ans,li,0,nums);
        return ans;
    }

    private void permutations(List<List<Integer>> ans,List<Integer> li,int idx,int[] nums){
        if(li.size()==nums.length){
            ans.add(new ArrayList<>(li));
            return ;
        }
        for(int i=0;i<li.size()+1;i++){
            li.add(i,nums[idx]);
            permutations(ans,li,idx+1,nums);
            li.remove(i);
        }

    }
}