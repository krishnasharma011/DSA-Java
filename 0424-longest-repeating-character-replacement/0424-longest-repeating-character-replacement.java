class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int ans=0;
        int left=0;
        int right=0;
        int maxFreq=1;
        while(right<n){
            char ch=s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,map.get(ch));
            if((right-left+1)-maxFreq>k){
                char temp=s.charAt(left);
                map.put(temp,map.get(temp)-1);
                left++;
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}