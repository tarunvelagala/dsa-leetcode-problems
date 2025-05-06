class Solution {

    public String reverseWords(String s) {
        String[] splitString = s.trim().split("\\s+");
        String res = "";
        for (int i = splitString.length-1; i >= 0; i--) {
            res = res.concat(splitString[i]);
            res = res.concat(" ");
        }
        return res.trim();
    }
}
