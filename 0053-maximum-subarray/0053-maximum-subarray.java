class Solution {
    public int maxSubArrayBruteForce(int[] nums) {
        if(nums.length == 1) {
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

    // Implemented using KDanes Algorithm.
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int globalSum = Integer.MIN_VALUE;

        for(int i = 0;i<nums.length;i++) {
            currSum += nums[i];
            globalSum = Math.max(globalSum, currSum);
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return globalSum;
    }
}