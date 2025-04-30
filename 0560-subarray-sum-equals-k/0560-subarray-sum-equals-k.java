class Solution {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int subArrayCount = 0;
        for (int i = 0; i <= n; i++) {
            int windowSum = 0;
            for (int j = i; j < n; j++) {
                windowSum += nums[j];
                if (windowSum == k) {
                    subArrayCount++;
                }
            }
        }
        return subArrayCount;
    }
}
