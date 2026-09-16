class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(n>m) return "";
        if(s.equals(t)) return s;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left=0;
        int right=0;
        String ans="";
        HashMap<Character,Integer> curr=new HashMap<>();
        int count=0;
        while(right<m){
            char ch=s.charAt(right);
            curr.put(ch,curr.getOrDefault(ch,0)+1);
            if(map.containsKey(ch) && curr.get(ch)<=map.get(ch)){
                count++;
            }
            while(count==n){
                if(ans.length()==0 || ans.length()>right-left+1){
                    ans=s.substring(left,right+1);
                }
                char temp=s.charAt(left);
                if(map.containsKey(temp) && curr.get(temp)<=map.get(temp)) {
                    count--;
                }
                curr.put(temp,curr.get(temp)-1);
                left++;
            }
            right++;
        }
        return ans;
    }
}