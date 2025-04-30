# 🪟 Fixed Sliding Window Pattern - DSA Notes

The **Fixed Sliding Window** pattern is used when:

- You're working with arrays or strings.
- You're asked to find something in **subarrays of fixed size `k`**.
- Example: "Find the max sum of a subarray of size `k`."

---

## 🧠 Core Idea

Instead of recalculating the sum of each window every time (which is O(n*k)), we:

1. **Calculate the sum** of the first window (first `k` elements).
2. **Slide the window** by one position:
   - Subtract the element going out.
   - Add the element coming in.
3. Keep track of the max or desired result.

✅ **Time Complexity:** O(n)  
✅ **Space Complexity:** O(1) (excluding input)

---

## 🧪 Problem Example

> Find the **maximum sum of any subarray of size `k`** in a given array.

---

## 🧾 Template - Java ☕

```java
public class Main {
    // Function to return the maximum sum of any subarray of size k
    public static int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;

        // Edge case: if array has fewer than k elements
        if (n < k) return -1;

        // Step 1: Calculate the sum of the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Step 2: Slide the window
        for (int i = k; i < n; i++) {
            // Subtract the element going out of the window
            windowSum = windowSum - arr[i - k];
            // Add the new element coming into the window
            windowSum = windowSum + arr[i];
            // Update max sum
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 6, 2, 3, 4, 5};
        int k = 2;
        System.out.println(maxSubarraySum(arr, k));  // Output: 13
    }
}
```

## 🧾 Template - Python 🐍

```python
```python
def max_subarray_sum(arr, k):
    n = len(arr)
    
    # If the array is smaller than k, no valid window
    if n < k:
        return -1

    # Step 1: Calculate the sum of the first window
    window_sum = sum(arr[:k])
    max_sum = window_sum

    # Step 2: Slide the window forward
    for i in range(k, n):
        # Subtract the element leaving the window
        window_sum -= arr[i - k]
        # Add the new element entering the window
        window_sum += arr[i]
        # Update max sum if current window's sum is greater
        max_sum = max(max_sum, window_sum)

    return max_sum

# Example usage
arr = [1, 7, 6, 2, 3, 4, 5]
k = 2
print(max_subarray_sum(arr, k))  # Output: 13
```

## 10 Important Fixed Sliding Window Problems for Interview Prep

1. [ ] **Maximum Sum Subarray of Size K** - Difficulty: Easy  
   [LeetCode - Maximum Sum Subarray of Size K](https://leetcode.com/problems/maximum-sum-subarray-of-size-k/)

2. [ ] **Minimum Sum Subarray of Size K** - Difficulty: Easy  
   [LeetCode - Minimum Sum Subarray of Size K](https://leetcode.com/problems/minimum-sum-subarray-of-size-k/)

3. [ ] **Maximum Average Subarray I** - Difficulty: Easy  
   [LeetCode - Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)

4. [ ] **Longest Substring with K Distinct Characters** - Difficulty: Medium  
   [LeetCode - Longest Substring with K Distinct Characters](https://leetcode.com/problems/longest-substring-with-k-distinct-characters/)

5. [ ] **Number of Subarrays with Sum at Most K** - Difficulty: Medium  
   [LeetCode - Number of Subarrays with Sum at Most K](https://leetcode.com/problems/number-of-subarrays-with-sum-at-most-k/)

6. [ ] **Find All Anagrams in a String** - Difficulty: Medium  
   [LeetCode - Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

7. [ ] **Permutation in String** - Difficulty: Medium  
   [LeetCode - Permutation in String](https://leetcode.com/problems/permutation-in-string/)

8. [ ] **Longest Substring with At Most K Distinct Characters** - Difficulty: Medium  
   [LeetCode - Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)

9. [ ] **Subarrays with K Different Integers** - Difficulty: Medium  
   [LeetCode - Subarrays with K Different Integers](https://leetcode.com/problems/subarrays-with-k-different-integers/)

10. [ ] **Sliding Window Maximum** - Difficulty: Medium  
    [LeetCode - Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
