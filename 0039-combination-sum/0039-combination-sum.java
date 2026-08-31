class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helper(candidates,target,ans,curr,0,0);
        return ans;
    }

    private void helper(int[] candidates,int target,List<List<Integer>> ans,List<Integer> curr,int i,int sum){
        if(sum==target){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        if(sum>target) return ;
        if(i==candidates.length){
            return ;
        }
        curr.add(candidates[i]);
        helper(candidates,target,ans,curr,i,sum+candidates[i]);
        curr.remove(curr.size()-1);
        helper(candidates,target,ans,curr,i+1,sum);
    }
}