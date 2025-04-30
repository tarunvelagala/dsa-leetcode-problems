# Fixed Sliding Window Technique - Quick Revision

- **Concept:**  
  A sliding window of fixed size `k` moves across the array.  
  Efficient for calculating results like sum, max, or min in subarrays.

- **Steps:**
  1. **Initialize the window:**  
     Calculate result for the first `k` elements. (0 -> k)
  2. **Slide the window:**  (k -> n)
     Subtract the element that goes out. [i-k]
     Add the new element coming in. [i] 
  3. **Update result:**  
     Track the max/min/sum/average as the window slides.

- **Time Complexity:**  
  O(n) – Each element is processed only once.

- **When to Use:**  
  - Fixed-size subarrays (sum, max, min, average).
  - Problems with contiguous subarrays.

- **Example Problem:**  
  **Maximum Sum Subarray of Size `k`:**  
  - Initialize the sum for the first `k` elements.  
  - Slide the window, update sum, and track max sum.

- **Common Problems:**
  - Maximum/Minimum Sum Subarray of Size `k`
  - Sliding Window Maximum/Minimum
  - Longest Substring with K Distinct Characters

- **Advantages:**  
  - Efficient, reduces redundant calculations.  
  - **O(n)** time complexity, optimal for large datasets.
