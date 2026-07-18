    // Leetcode:-56. Merge Intervals

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        // Initialize first interval
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            // If intervals overlap, extend the end
            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
            } 
            // No overlap, save current interval
            else {
                res.add(new int[]{start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }

        // Add the last merged interval
        res.add(new int[]{start1, end1});

        // Convert List to 2D array
        return res.toArray(new int[res.size()][]);
        
              //  Convert List to 2D array
        return res.toArray(new int[0][]);
    }
}