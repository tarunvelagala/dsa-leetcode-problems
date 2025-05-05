class Solution {

    // TODO: Update the solution with O(1) time complexity.
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> numberFrequency = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberFrequency.containsKey(nums[i])) {
                numberFrequency.put(nums[i], numberFrequency.getOrDefault(nums[i], 0) + 1);
                res.add(nums[i]);
            }
            numberFrequency.put(nums[i], 1);
        }
        return res;
    }
}
