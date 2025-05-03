class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr.length < 1 || k < 1 || threshold < 1) return arr[0];

        int currentAverage = 0;
        int subArrayCount = 0;
        int subArraySum = 0;

        for (int i = 0; i < k; i++) {
            subArraySum += arr[i];
        }

        if (subArraySum / k >= threshold) {
            subArrayCount++;
        }

        for (int i = k; i < arr.length; i++) {
            subArraySum -= arr[i - k];
            subArraySum += arr[i];

            if (subArraySum / k >= threshold) {
                subArrayCount++;
            }
        }
        return subArrayCount;
    }

    public int numOfSubarraysBruteForce(int[] arr, int k, int threshold) {
        if (arr.length < 1 || k < 1 || threshold < 1) return arr[0];

        int currentAverage = 0;
        int subArrayCount = 0;

        for (int i = 0; i < arr.length - k + 1; i++) {
            currentAverage = 0;
            int subArraySum = 0;
            for (int j = 0; j < k; j++) {
                subArraySum += arr[i + j];
            }
            if (subArraySum / k >= threshold) {
                subArrayCount++;
            }
        }
        return subArrayCount;
    }
}
