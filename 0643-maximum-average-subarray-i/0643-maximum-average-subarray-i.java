class Solution {
    public double findMaxAverage(int[] nums, int k) {

        // Handle the base case where length = 1 and k = 1
        if (nums.length == 1 && k == 1) {
            return (double) nums[0];
        }

        double maxAverage = 0.0;
        double sum = 0.0;

        // Calculate the intial average of the window. 
        for(int i = 0;i<k;i++) {
            sum += nums[i];
        }

        maxAverage = sum/k;

        // Calculate the sum and maxAverage
        for(int i =k;i<nums.length;i++) {
            // 1. Remove the previous windowStart (i-k) element i.e SHRINK the window i-k
            sum -= nums[i-k];
            // 2. Add the windowEnd i element i.e expand the window. 
            sum += nums[i];
            maxAverage = Math.max(maxAverage, sum/k);
        } 

        return maxAverage;
    }
}
