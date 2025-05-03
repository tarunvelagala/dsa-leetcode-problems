class Solution {

    // Fixed Size Sliding Window
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr.length < 1) return arr[0];

        int currentAverage = 0;
        int subArrayCount = 0;
        int subArraySum = 0;

        for (int i = 0; i < k; i++) {
            subArraySum += arr[i];
        }

        if (subArraySum >= threshold * k) {
            subArrayCount++;
        }

        for (int i = k; i < arr.length; i++) {
            subArraySum -= arr[i - k];
            subArraySum += arr[i];

            if (subArraySum >= threshold * k) {
                subArrayCount++;
            }
        }
        return subArrayCount;
    }

    // BruteForce
    public int numOfSubarraysBruteForce(int[] arr, int k, int threshold) {
        if (arr.length < 1) return arr[0];

        int currentAverage = 0;
        int subArrayCount = 0;

        for (int i = 0; i < arr.length - k + 1; i++) {
            currentAverage = 0;
            int subArraySum = 0;
            for (int j = 0; j < k; j++) {
                subArraySum += arr[i + j];
            }
            if (subArraySum >= threshold * k) {
                subArrayCount++;
            }
        }
        return subArrayCount;
    }
}
