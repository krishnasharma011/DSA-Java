class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int n=s.length();
        if(n<=1) return n;
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        while(right<n){
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                while(map.get(ch)>0){
                    char temp=s.charAt(left);
                    map.put(temp,map.get(temp)-1);
                    left++;
                }
            }
            map.put(ch,1);
            ans=Math.max(ans,right-left+1);
            right++;    
        }
        return ans;
    }
}