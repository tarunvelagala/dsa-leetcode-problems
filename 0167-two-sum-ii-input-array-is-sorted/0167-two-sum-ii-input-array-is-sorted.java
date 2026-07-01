class Solution {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] { -1, -1 };
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int total = nums[low] + nums[high];
            if (total == target) return new int[] { low + 1, high + 1 };
            if (total > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[]{-1, -1};
    }
}
