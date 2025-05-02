# 🔄 Variable Sliding Window Pattern - DSA Notes

The **Variable Sliding Window** pattern is used when:

- The size of the sliding window **changes dynamically** based on conditions.
- You're asked to find **subarrays or substrings that satisfy a condition** (e.g., at most K distinct characters, max sum ≤ target).
- Useful for problems involving **min/max length** of subarrays or conditions on sum/frequency.

---

## 🧠 Core Idea

We use two pointers `start` and `end` to represent the window:

1. Expand the window by moving `end` to the right.
2. While the condition is **not valid**, shrink the window from the left by moving `start`.
3. Update the result when the condition is satisfied (e.g., max length, min length, count).

✅ **Time Complexity:** O(n) — each element is visited at most twice  
✅ **Space Complexity:** O(k) — typically for a hashmap or frequency array

---

## 🧪 Problem Example

> Find the **length of the longest substring with at most K distinct characters**.

---

## ☕ Java Template – Sliding Window with HashMap

```java
import java.util.*;

public class LongestUniqueSubstring {

    public static int lengthOfLongestSubstring(String s) {
        // HashMap to store character -> last seen index
        Map<Character, Integer> seen = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);

            // If character is already seen and is within the current window
            if (seen.containsKey(currentChar) && seen.get(currentChar) >= windowStart) {
                // Move the start to 1 position after the previous occurrence
                windowStart = seen.get(currentChar) + 1;
            }

            // Update last seen index
            seen.put(currentChar, windowEnd);

            // Update the maximum length found
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
```

## 🧾 Template - Python 🐍

```python
def length_of_longest_substring(s):
    # Dictionary to store the last seen index of each character
    seen = {}
    window_start = 0
    max_length = 0

    for window_end, char in enumerate(s):
        # If the character is already seen and its last index is inside the current window
        if char in seen and seen[char] >= window_start:
            # Move window start to 1 position after last occurrence
            window_start = seen[char] + 1

        # Update the last seen index
        seen[char] = window_end

        # Update the max length
        max_length = max(max_length, window_end - window_start + 1)

    return max_length

# Example usage
s = "abcabcbb"
print("Longest substring without repeating characters:", length_of_longest_substring(s))  # Output: 3
```
---

### 📚 Problem List

1. [ ] **Longest Substring Without Repeating Characters** – *Medium*  
   📌 *Find the length of the longest substring without duplicate characters.*  
   🔗 [LeetCode #3](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

2. [ ] **Longest Substring with At Most K Distinct Characters** – *Medium*  
   📌 *Find the longest substring that contains at most K distinct characters.*  
   🔗 [LeetCode #340](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)

3. [ ] **Minimum Window Substring** – *Hard*  
   📌 *Find the minimum-length substring that contains all characters of another string.*  
   🔗 [LeetCode #76](https://leetcode.com/problems/minimum-window-substring/)

4. [ ] **Longest Repeating Character Replacement** – *Medium*  
   📌 *Find the length of the longest substring that can become all the same character after K replacements.*  
   🔗 [LeetCode #424](https://leetcode.com/problems/longest-repeating-character-replacement/)

5. [ ] **Fruit Into Baskets** – *Medium*  
   📌 *Find the longest subarray with at most 2 different fruits (characters).*  
   🔗 [LeetCode #904](https://leetcode.com/problems/fruit-into-baskets/)

6. [ ] **Max Consecutive Ones III** – *Medium*  
   📌 *Find the maximum number of consecutive 1s you can get by flipping at most K 0s.*  
   🔗 [LeetCode #1004](https://leetcode.com/problems/max-consecutive-ones-iii/)

7. [ ] **Subarrays with K Different Integers** – *Hard*  
   📌 *Count the number of subarrays with exactly K different integers.*  
   🔗 [LeetCode #992](https://leetcode.com/problems/subarrays-with-k-different-integers/)

8. [ ] **Count Number of Nice Subarrays** – *Medium*  
   📌 *Count the number of subarrays with exactly K odd numbers.*  
   🔗 [LeetCode #1248](https://leetcode.com/problems/count-number-of-nice-subarrays/)

9. [ ] **Minimum Size Subarray Sum** – *Medium*  
   📌 *Find the minimal length of a contiguous subarray with sum ≥ target.*  
   🔗 [LeetCode #209](https://leetcode.com/problems/minimum-size-subarray-sum/)

10. [ ] **Binary Subarrays With Sum** – *Medium*  
   📌 *Count subarrays of a binary array that sum up to a target.*  
   🔗 [LeetCode #930](https://leetcode.com/problems/binary-subarrays-with-sum/)

---

✅ **Tip:** Start by mastering problems like #1, #2, and #9. These lay the foundation for solving more complex ones involving maps, counters, and exact/at most/exactly K logic.