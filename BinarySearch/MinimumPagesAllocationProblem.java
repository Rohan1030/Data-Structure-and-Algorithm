package BinarySearch;

public class MinimumPagesAllocationProblem {

  public class AllocateMinimumPages {

    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int students = 2;
        System.out.println("Minimum Maximum Pages: " + findPages(pages, students));
    }

    public static int findPages(int[] pages, int students) {
        if (students > pages.length) return -1; // not enough books

        int low = 0, high = 0;
        for (int p : pages) {
            low = Math.max(low, p); // at least one book’s max
            high += p;              // at most all pages together
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(pages, students, mid)) {
                result = mid;
                high = mid - 1; // try smaller max
            } else {
                low = mid + 1; // need larger max
            }
        }
        return result;
    }

    private static boolean isPossible(int[] pages, int students, int maxPages) {
        int studentCount = 1;
        int currentSum = 0;

        for (int p : pages) {
            if (currentSum + p <= maxPages) {
                currentSum += p;
            } else {
                studentCount++;
                currentSum = p;

                if (studentCount > students) return false;
            }
        }
        return true;
    }
}

  
}
