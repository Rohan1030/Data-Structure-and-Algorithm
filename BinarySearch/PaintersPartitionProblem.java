package BinarySearch;
import java.util.*;
public class PaintersPartitionProblem {
    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int painters = 2;

        System.out.println(minTime(boards, painters));
    }

    public static int minTime(int[] boards, int k) {
        int low = 0, high = 0;

        // find range
        for (int len : boards) {
            low = Math.max(low, len); // longest single board
            high += len;              // sum of all boards
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPaint(boards, k, mid)) {
                ans = mid;      // possible
                high = mid - 1; // try smaller
            } else {
                low = mid + 1;  // need more time
            }
        }

        return ans;
    }

    // helper: check if k painters can paint within maxTime
    private static boolean canPaint(int[] boards, int k, int maxTime) {
        int paintersUsed = 1;
        int currentSum = 0;

        for (int len : boards) {
            if (currentSum + len <= maxTime) {
                currentSum += len; // same painter
            } else {
                paintersUsed++;    // new painter
                currentSum = len;  // reset load

                if (paintersUsed > k) {
                    return false;  // not possible
                }
            }
        }

        return true;
    }
}
