# 🔄 Variable Sliding Window Technique - Quick Revision

- **Concept:**  
  A dynamic (variable-size) window that grows or shrinks based on a condition (e.g., character uniqueness, frequency, sum constraints, etc.).  
  Used when window size is **not fixed** and **depends on the data**.

---

- **Steps:**
  1. **Initialize window pointers:**  
     Start with two pointers: `start = 0`, iterate `end` through the array/string.
  2. **Expand the window:**  
     Add the current element at `end` to your window logic (e.g., map, set, sum).
  3. **Shrink the window (if needed):**  
     If a condition is violated (e.g. more than K distinct characters), move `start` forward and remove elements accordingly.
  4. **Update result:**  
     Check and update result when conditions are satisfied (e.g., max length, min length, count).

---

- **Time Complexity:**  
  O(n) – Each element is added and removed from the window at most once.

- **When to Use:**  
  - Conditions depend on window content (not fixed size).
  - Substrings/subarrays with:
    - No repeats
    - At most/exactly K distinct elements
    - Sum/frequency conditions

---

- **Example Problem:**  
  **Longest Substring Without Repeating Characters**  
  - Use a set or map to track characters.  
  - Expand the window; if duplicate found, shrink from the start.  
  - Track the longest valid window.

---

- **Common Problems:**
  - Longest Substring Without Repeating Characters
  - Longest Substring with At Most/Exactly K Distinct Characters
  - Minimum Window Substring
  - Max Consecutive Ones III
  - Subarrays with Sum at Most/Exactly K
  - Fruit Into Baskets (at most 2 types)

---

- **Advantages:**  
  - Flexible – adapts to constraints within the data.  
  - Optimal for problems involving frequency/count/condition enforcement.  
  - **O(n)** time complexity using maps, sets, or frequency arrays.
