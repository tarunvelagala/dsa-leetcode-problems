class Solution {

    // Optimal 2
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < s.length() - 3 + 1; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if (a != b && b != c && c != a) {
                count++;
            }
        }
        return count;
    }

    public int countGoodSubstrings2(String s) {
        if (s.length() < 3) { //  if the input string is less than 3, return 0
            return 0;
        }
        int count = 0;
        Set<Character> mySet = new HashSet<>(); // use set to store unique characters
        int start = 0, end = 3;

        String sub = s.substring(start, end);
        for (int i = 0; i < 3; i++) {
            mySet.add(sub.charAt(i));
        }
        if (mySet.size() == 3) count++;

        for (end++, start++; end < s.length() + 1; start++, end++) {
            mySet.clear(); // reset the set
            sub = s.substring(start, end);
            for (int k = 0; k < 3; k++) {
                mySet.add(sub.charAt(k));
            }
            if (mySet.size() == 3) count++;
        }
        return count;
    }
}
