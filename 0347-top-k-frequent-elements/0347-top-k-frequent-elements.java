class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // Prepare the Frequency Map {element: frequency}
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        // Initialize Min-Heap based on the frequency of the element i.e the value of map element.
        final Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // For the entries in the frequencyMap
        // If the insert the element into the heap.
        // If the Heap size is greater than K then poll the root element.
        // This sets the smallest frequency element as the root.
        for (final Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 3. If the minHeap is not empty we put that into result.
        final int[] result = new int[k];
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
