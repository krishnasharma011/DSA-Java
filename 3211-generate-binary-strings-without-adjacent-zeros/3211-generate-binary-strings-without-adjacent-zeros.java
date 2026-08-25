class Solution {
    public List<String> validStrings(int n) {
        List<String> ans=new ArrayList<>();
        helper(n,ans,"",0);
        return ans;
    }

    private void helper(int n,List<String> ans,String s,int i){
        if(i==n){
            ans.add(s);
            return ;
        }
        if(s.isEmpty() || s.charAt(i-1)=='1'){
            helper(n,ans,s+1,i+1);
            helper(n,ans,s+0,i+1);
        }
        else helper(n,ans,s+1,i+1);
    }
}