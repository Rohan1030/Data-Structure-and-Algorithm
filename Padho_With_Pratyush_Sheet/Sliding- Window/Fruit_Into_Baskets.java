      //Leetcode :-904. Fruit Into Baskets


class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int n = fruits.length;
        int maxLen = 0; // max fruits collectable with only 2 baskets
        HashMap<Integer, Integer> freq = new HashMap<>(); // fruit type -> count in window

        for (int right = 0; right < n; right++)  // expand window
        {
            int c = fruits[right];

            freq.put(c, freq.getOrDefault(c, 0) + 1); // add fruit to window

            while (freq.size() > 2) // more than 2 basket types -> shrink
            {
                int leftFruit = fruits[left];
                freq.put(leftFruit, freq.get(leftFruit) - 1); // remove one occurrence

                if (freq.get(leftFruit) == 0)
                {
                    freq.remove(leftFruit); // fruit type fully gone, drop key
                }
                left++; // shrink window
            }
            maxLen = Math.max(maxLen, right - left + 1); // valid window (<=2 types), update answer
        }
        return maxLen;
    }
}