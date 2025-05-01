class Solution {

    // Generate all the arrays of i, j -> i, i+1
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        HashMap<Integer, Integer> x = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int complement = target - num;
            if (x.containsKey(complement)) {
                ans[0] = x.get(complement);
                ans[1] = i;
                return ans;
            }
            x.put(nums[i], i);
        }
        return ans;
    }
}
