class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n=pattern.length();
        ArrayList<String> li=new ArrayList<>();
        String temp="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==' '){
                li.add(temp);
                temp="";
            }
            else temp+=ch;
        }
        li.add(temp);
        if(n!=li.size()) return false;
        HashMap<Character,String> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(li.get(i))){
                    return false;
                }
            }
            else{
                if(map.containsValue(li.get(i))){
                    return false;
                }
                map.put(ch,li.get(i));
            } 
        }
        return true;
    }
}