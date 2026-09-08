class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        Arrays.sort(nums);
        permutations(ans,li,0,nums);
        HashSet<List<Integer>> set=new HashSet<>();
        for(int i=0;i<ans.size();i++){
            set.add(ans.get(i));
        }
        List<List<Integer>> l=new ArrayList<>();
        for(List<Integer> temp:set){
            l.add(temp);
        }
        return l;
    }

    private void permutations(List<List<Integer>> ans,List<Integer> curr,int idx,int[] nums){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int i=0;i<curr.size()+1;i++){
            curr.add(i,nums[idx]);
            permutations(ans,curr,idx+1,nums);
            curr.remove(i);
        }
    }
}