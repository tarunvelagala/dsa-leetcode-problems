class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Edge Cases
        if (k <= 1) return 0;

        // Initialization
        int left = 0;
        int right = 0;
        int subArrayCount = 0;
        int product = 1;
        while (right < nums.length) {
            
            // Calculate the condition
            product *= nums[right];

            // While(invalid Condition) -> Shrink the window by removing the left number.
            while (product >= k) {
                product /= nums[left++];
            }

            // Finally calculate the asked element.
            subArrayCount += right - left + 1;
            right++;
        }
        return subArrayCount;
    }
}
