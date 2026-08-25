class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int aCount=0;
        int bCount=0;
        int cCount=0;
        int left=0;
        int right=0;
        int ans=0;
        while(right<n){
            char ch=s.charAt(right);
            if(ch=='a') aCount++;
            else if(ch=='b') bCount++;
            else cCount++;
            while(aCount>0 && bCount>0 && cCount>0){
                char c=s.charAt(left);
                if(c=='a'){
                    aCount--;
                }
                else if(c=='b'){
                    bCount--;
                }
                else {
                    cCount--;
                }
                left++;
            }
            ans+=left;
            right++;
        }
        return ans;
    }
}