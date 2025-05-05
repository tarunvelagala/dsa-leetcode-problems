import java.util.*;

class Solution {

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++) {
            if(i != 0 && nums[i-1] == nums[i]) continue;
            int j = i+1;
            int k = nums.length - 1;
            while(j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if(s<0) {
                    j++;
                } else if(s > 0) {
                    k--;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(triplet);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSumBetter(int[] nums) {
        final Set<List<Integer>> result = new HashSet<>();
        for(int i = 0;i<nums.length;i++) {
            Set<Integer> subArrayElementsMap = new HashSet();
            for(int j = i+1;j<nums.length;j++) {
                int complement = -(nums[i] + nums[j]);
                if(subArrayElementsMap.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    triplet.sort(null);
                    result.add(triplet);
                }
                subArrayElementsMap.add(nums[j]);
            }
        }
        return List.copyOf(result);
    }

    public List<List<Integer>> threeSumBF(int[] nums) {
        final Set<List<Integer>> result = new HashSet<>();
        for(int i =0;i<nums.length;i++) {
            for(int j = i+1;i<nums.length;j++) {
                for(int k = j+1;k<nums.length;k++) {
                    if(nums[i] + nums[j] + nums[k] == 0 && nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(null);
                        result.add(triplet);
                    }
                } 
            }
        }
        return List.copyOf(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumOptimal(nums);
    }
}