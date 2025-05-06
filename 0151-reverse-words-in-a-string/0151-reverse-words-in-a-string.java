class Solution {

    public String reverseWords(String s) {
        String[] splitString = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = splitString.length - 1; i >= 0; i--) {
            res = res.append(splitString[i]);
            if (i != 0) res.append(" ");
        }
        return res.toString();
    }
}
