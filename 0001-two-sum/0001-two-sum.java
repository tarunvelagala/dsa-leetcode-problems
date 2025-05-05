class Solution {

    // Generate all the arrays of i, j -> i, i+1
    // Uses a HashMap to store the elements and its index
    public int[] twoSumBetter(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int complement = target - num;
            if (indexMap.containsKey(complement)) {
                return new int[] { i, indexMap.get(complement) };
            }
            indexMap.put(nums[i], i);
        }
        return new int[] {};
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (num + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
