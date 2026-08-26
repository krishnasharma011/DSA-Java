class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int left=0;
        int right=0;
        int count=0;
        int len=0;
        String ans="";
        while(right<n){
            char ch=s.charAt(right);
            if(ch=='1') count++;
            while(count>k){
                if(s.charAt(left)=='1') count--;
                left++;
            }
            while(count==k && s.charAt(left)=='0'){
                left++;
            }
            if(count==k){
                String candidate=s.substring(left,right+1);
                if(ans.equals("") || isLexicographicallySmaller(candidate,ans)){
                    ans=candidate;
                }
            }
            right++;
        }
        return ans;
    }

    private boolean isLexicographicallySmaller(String a,String b){
        if(a.length()<b.length()) return true;
        else if(a.length()>b.length()) return false;
        int i=0;
        while(i<a.length()){
            char c1=a.charAt(i);
            char c2=b.charAt(i);
            if(c1=='0' && c2=='1') return true;
            else if(c1=='1' && c2=='0') return false;
            i++;
        }
        return false;
    }
}