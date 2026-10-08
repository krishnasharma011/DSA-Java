class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int bracks = 0;
        String ans="";
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                if(bracks > 0) {
                    ans += ch;
                }
                bracks++;
            }
            else {
                bracks--;
                if(bracks > 0) {
                    ans += ch;
                }
            }
        }
        return ans;
    }
}