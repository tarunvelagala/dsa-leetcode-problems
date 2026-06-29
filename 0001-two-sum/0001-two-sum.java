import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // I.O.C - 
        // B.O.T - 
        // S.A.Y - 
        // C.O.D.E - 
        // T.E.S.T - 

        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        final Map<Integer, Integer> complementMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complementMap.containsKey(complement)) {
                return new int[] { i, complementMap.getOrDefault(complement, 0) };
            } else {
                complementMap.put(nums[i], i);
            }
        }
        return new int[] { -1, -1 };
    }
}