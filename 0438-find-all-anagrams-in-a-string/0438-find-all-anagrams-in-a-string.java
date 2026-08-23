class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        List<Integer> ans=new ArrayList<>();
        if(m>n) return ans;
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<m;i++){
            char ch=p.charAt(i);
            char ch2=s.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            map2.put(ch2,map2.getOrDefault(ch2,0)+1);
        }
        if(map1.equals(map2)) ans.add(0);
        int left=0;
        int right=m;
        while(right<n){
            char ch=s.charAt(right);
            char ch2=s.charAt(left);
            int freq=map2.getOrDefault(ch2,0);
           if(freq == 1) {
                map2.remove(ch2);
            } else {
                map2.put(ch2, freq - 1);
            }
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if(map1.equals(map2)) ans.add(left+1);
            left++;
            right++;
        }
        return ans;
    }
}