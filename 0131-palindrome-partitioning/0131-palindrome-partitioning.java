class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> li=new ArrayList<>();
        helper(s,ans,li,0);
        return ans;
    }

    private void helper(String s,List<List<String>> ans,List<String> li,int idx){
        if(idx>=s.length()){
            ans.add(new ArrayList<>(li));
            return ;
        }
        for(int i=idx;i<s.length();i++){
            String curr=s.substring(idx,i+1);
            if(isPalindrome(curr)){
                li.add(curr);    
                helper(s,ans,li,i+1);
                li.remove(li.size()-1);
            } 
        }
    }

    private boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}