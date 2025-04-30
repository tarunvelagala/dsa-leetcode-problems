class Solution {

    public boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public int maxVowels(String s, int k) {
        // Base Case
        if (s.length() < 0) {
            return 0;
        }

        int maxVowelCount = 0;
        int currVowelCount = 0;

        // Initialize the sliding window of size k
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currVowelCount++;
            }
        }
        maxVowelCount = currVowelCount;

        // For remaining n elements i.e k -> n
        // if s[i] is a vowel increment the count
        // if s[i-k] is vowel decrement the count
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currVowelCount++;
            }
            if (isVowel(s.charAt(i - k))) {
                currVowelCount--;
            }

            // Calculate the maxVowelCount
            maxVowelCount = Math.max(maxVowelCount, currVowelCount);
        }
        return maxVowelCount;
    }
}
