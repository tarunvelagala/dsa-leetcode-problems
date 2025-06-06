class Solution {

    public List<List<Integer>> threeSumBF(int[] nums) {
        // Generate all sub arrays
        // nums[i] + nums[j] + nums[k] = 0
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplets = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplets.sort(null);
                        res.add(triplets);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public List<List<Integer>> threeSumBetter(int[] nums) {
        final Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            final Set<Integer> numberIndexSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int complement = -(nums[i] + nums[j]);
                if (numberIndexSet.contains(complement)) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], complement);
                    triplets.sort(null);
                    result.add(triplets);
                }
                numberIndexSet.add(nums[j]);
            }
        }
        return List.copyOf(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // [-1, -1, 0, 1, 2, 4]
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // If the duplicate element is present then we continue
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            // Initialize j pointer = i + 1 (a head of i always)
            int j = i + 1;
            // Initialize k pointer -> n (at the last)
            int k = nums.length - 1;

            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                // Check if the sum < zero, increment the j pointer to reach middle (0 is present after sorting)
                if (s < 0) {
                    j++;
                    // Check if the sum > zero, decrement the k pointer to reach middle (0 is present after sorting)
                } else if (s > 0) {
                    k--;
                    // If we found a pair add them to the list and incr/decr pointers.
                } else {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(triplets);
                    j++;
                    k--;
                    // IMP -> We would check if the adjacent pairs of j are equivalent. Likewise k.
                    // it means that its redundant summing. Rather than that we could skip it.
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return result;
    }
}
