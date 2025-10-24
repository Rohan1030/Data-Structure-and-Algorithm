package BinarySearch;
public class KokoEatingBananas {


   //   LeetCode: 875. Koko Eating Bananas

  class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // find maximum pile
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        int ans = right;

        // binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isEatingSpeedValid(piles, mid, h)) {
                ans = mid;        // possible answer, try smaller
                right = mid - 1;
            } else {
                left = mid + 1;   // too slow, increase speed
            }
        }

        return ans;
    }

    // check if Koko can finish with speed 'speed'
    private boolean isEatingSpeedValid(int[] piles, int speed, int h) {
        int hs = 0;
        for (int i = 0; i < piles.length; i++) {
            hs += piles[i] / speed;
            if (piles[i] % speed != 0) {
                hs += 1;
            }
            if (hs > h) {
                return false;
            }
        }
        return true;
    }
}

  
}
