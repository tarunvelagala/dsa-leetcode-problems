class Solution {

    public List<List<Integer>> threeSumO(int[] nums) {
        // Generate all sub arrays
        // nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k] &&
        // nums[i] + nums[j] + nums[k] = 0
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 && nums[i] != nums[j] && nums[j] != nums[k] && nums[k] != nums[i]) {
                        List<Integer> triplets = List.of(nums[i], nums[j], nums[k]);
                        res.add(triplets);
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSumBetter(int[] nums) {
        final Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> numberIndexSet = new HashSet<>();
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
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s < 0) {
                    j++;
                } else if (s > 0) {
                    k--;
                } else {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(triplets);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return result;
    }
}
