// Leetcode :- 560. Subarray Sum Equals K

class Solution {
    public int subarraySum(int[] nums, int k) {

        int prefixSum = 0;
        int count = 0;

        // Stores: Prefix Sum -> Frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Empty prefix sum
        map.put(0, 1);

        for (int num : nums) {

            // Update running prefix sum
            prefixSum += num;

            // Check if a valid subarray exists
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Store current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}