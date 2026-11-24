class pair {
    String s;
    int t;

    public pair(String s, int t) {
        this.s = s;
        this.t = t;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        Queue<pair> q = new ArrayDeque<>();
        q.offer(new pair(beginWord, 1));
        while (!q.isEmpty()) {
            pair p = q.poll();
            String s = p.s;
            int t = p.t;
            if (s.equals(endWord))
                return t;
            for (int i = 0; i < s.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    String temp = s.substring(0, i) + ch + s.substring(i + 1);
                    if (set.contains(temp)) {
                        q.offer(new pair(temp, t + 1));
                        set.remove(temp);
                    }
                }
            }
        }
        return 0;
    }
}