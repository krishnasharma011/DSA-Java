class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n=s.length();
        int len=words.length;
        int l=words[0].length();
        List<Integer> ans=new ArrayList<>();
        if(n<len*l) return ans;
        HashMap<String,Integer> map=new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int concatLen=len*l;
        for(int offset=0;offset<l;offset++){
            int left=offset;
            int right=offset;
            HashMap<String,Integer> current=new HashMap<>();
            while(right+l<=n){
                String temp=s.substring(right,right+l);
                if(!map.containsKey(temp)){
                    current.clear();
                    left=right+l;
                } else {
                    current.put(temp,current.getOrDefault(temp,0)+1);
                    while (current.get(temp) > map.get(temp)) {
                        String remove=s.substring(left,left+l);
                        current.put(remove,current.get(remove)-1);
                        left+=l;
                    }
                }
                if(right+l-left==concatLen){
                    ans.add(left);
                    String remove=s.substring(left,left+l);
                    current.put(remove,current.get(remove)-1);
                    left+=l;
                } 
                right+=l;
            }
        }
        return ans;
    }
}