package BinarySearch;

public class CountOccurrences {

        

  class Solution {
    public int countOccurrences(int[] nums, int target) {
        int first = findFirst(nums, target);
        if (first == -1) return 0;
        int last = findLast(nums, target);
        return last - first + 1;
    }
    
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return ans;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return ans;
    }
}

  
}
