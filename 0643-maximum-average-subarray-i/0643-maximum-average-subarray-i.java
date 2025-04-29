class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return (double) nums[0];
        }

        double maxAverage = 0.0;
        double sum = 0.0;
        for(int i = 0;i<k;i++) {
            sum += nums[i];
        }

        maxAverage = sum/k;

        for(int i =k;i<nums.length;i++) {
            sum -= nums[i-k];
            sum += nums[i];
            maxAverage = Math.max(maxAverage, sum/k);
        } 

        return maxAverage;
    }
}
