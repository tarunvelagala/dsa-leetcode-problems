class Solution {

    public int maxSubArrayBruteForce(int[] nums) {
        // Base Case
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // Implemented using K'Danes Algorithm.
    public int maxSubArray(int[] nums) {
        // Base Case
        if (nums.length == 1) {
            return nums[0];
        }

        int currSum = 0;
        int globalSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            globalSum = Math.max(globalSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return globalSum;
    }
}
