class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int max=0;
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if(isVowel(ch)) max++;
        }
        int temp=max;
        int ans=max;
        int left=0;
        int right=k;
        while(right<n){
            char ch=s.charAt(right);
            if(isVowel(ch)) temp++;
            if(isVowel(s.charAt(left))) temp--;
            ans=Math.max(ans,temp);
            left++;
            right++;
        }
        return ans;
    }

    private boolean isVowel(Character ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
        return false;
    }
}