      //  Leetcode:-  57. Insert Interval


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();

        // Current interval to be inserted/merged
        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] interval : intervals) {

            // Current interval is completely before new interval
            if (interval[1] < start) {
                res.add(interval);
            }

            // Current interval is completely after new interval
            else if (interval[0] > end) {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }

            // Intervals overlap, merge them
            else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }

        // Add the last merged interval
        res.add(new int[]{start, end});

        // Convert List<int[]> to int[][]
        return res.toArray(new int[res.size()][]);
    }
}