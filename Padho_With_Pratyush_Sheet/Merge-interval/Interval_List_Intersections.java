        // Leetcode :- 986. Interval List Intersections

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> res = new ArrayList<>();

        // Pointers for both interval lists
        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {

            // Find the common (overlapping) interval
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            // Valid intersection
            if (start <= end) {
                res.add(new int[]{start, end});
            }

            // Move the interval that ends first
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert List<int[]> to int[][]
        return res.toArray(new int[res.size()][]);
    }
}