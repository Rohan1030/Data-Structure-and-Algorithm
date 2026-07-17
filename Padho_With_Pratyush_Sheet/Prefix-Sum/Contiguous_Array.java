      // Leetcode :- 525. Contiguous Array


class Solution {
    public int findMaxLength(int[] nums) {

        int one = 0;
        int zero = 0;
        int res = 0;

        // Stores: Difference -> First index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Count 0s and 1s
            if (nums[i] == 0) {
                zero++;
            } else {
                one++;
            }

            // Current difference
            int diff = one - zero;

            // Equal 0s and 1s from index 0
            if (diff == 0) {
                res = Math.max(res, i + 1);
                continue;
            }

            // Same difference found before
            if (map.containsKey(diff)) {
                res = Math.max(res, i - map.get(diff));
            } else {
                // Store first occurrence
                map.put(diff, i);
            }
        }

        return res;
    }
}