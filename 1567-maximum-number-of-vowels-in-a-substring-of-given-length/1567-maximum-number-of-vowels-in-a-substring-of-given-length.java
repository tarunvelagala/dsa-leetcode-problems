class Solution {

    public boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public int maxVowels(String s, int k) {
        // Base Case
        if (s.length() < 0) {
            return 0;
        }

        int maxLength = 0;
        int currLength = 0;

        // Initialize the sliding window of size k
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currLength++;
            }
        }
        maxLength = currLength;

        // For remaining n elements i.e k -> n
        // if s[i] is a vowel increment the count
        // if s[i-k] is vowel decrement the count
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currLength++;
            }
            if (isVowel(s.charAt(i - k))) {
                currLength--;
            }

            // Calculate the maxLength
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}
