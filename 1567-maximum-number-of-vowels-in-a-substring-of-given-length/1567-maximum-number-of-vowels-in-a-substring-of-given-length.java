class Solution {

    public boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    // Bruteforce approach
    public int maxVowelsBruteForce(String s, int k) {
        int maxNumberOfVowels = 0;
        int currentNumberOfVowels = 0;

        for (int i = 0; i < s.length() - k + 1; i++) {
            currentNumberOfVowels = 0;
            for (int j = i; j < i + k; j++) {
                if (isVowel(s.charAt(j))) {
                    currentNumberOfVowels++;
                }
            }
            maxNumberOfVowels = Math.max(maxNumberOfVowels, currentNumberOfVowels);
        }
        return maxNumberOfVowels;
    }

    // Fixed Size sliding window of size k.
    public int maxVowels(String s, int k) {
        // Base Case
        if (s.length() < 0) {
            return 0;
        }

        int maxNumberOfVowels = 0;
        int currentNumberOfVowels = 0;

        // Initialize the sliding window of size k
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentNumberOfVowels++;
            }
        }
        maxNumberOfVowels = currentNumberOfVowels;

        // For remaining n elements i.e k -> n
        // if s[i] is a vowel increment the count
        // if s[i-k] is vowel decrement the count
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentNumberOfVowels++;
            }
            if (isVowel(s.charAt(i - k))) {
                currentNumberOfVowels--;
            }

            // Calculate the maxVowelCount
            maxNumberOfVowels = Math.max(maxNumberOfVowels, currentNumberOfVowels);
        }
        return maxNumberOfVowels;
    }
}
