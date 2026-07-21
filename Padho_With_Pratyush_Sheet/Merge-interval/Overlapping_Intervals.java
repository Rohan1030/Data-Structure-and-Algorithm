  //  GFG :-  Overlapping Intervals
class Solution {
    static boolean isIntersect(int[][] intervals) {

        // Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize with the first interval
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Current interval
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            // Overlap found
            if (end1 >= start2) {
                return true;
            }

            // Move to the current interval
            start1 = start2;
            end1 = end2;
        }

        // No overlapping intervals
        return false;
    }
}