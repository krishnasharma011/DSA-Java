class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int even = 0;
        for (char ch : map.keySet()) {
            even += map.get(ch) / 2;
        }
        int ans = even * 2;
        if (ans < s.length()) {
            ans++;
        }
        return ans;
    }
}