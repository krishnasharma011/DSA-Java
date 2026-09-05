class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        permutation(nums,ans,li,0);
        return ans;
    }

    private void permutation(int[] nums,List<List<Integer>> li,List<Integer> curr,int i){
        if(i==nums.length){
            li.add(new ArrayList<>(curr));
            return;
        }
        for(int j=0;j<i+1;j++){
            curr.add(j,nums[i]);
            permutation(nums,li,curr,i+1); 
            curr.remove(j);
        }
    }
}