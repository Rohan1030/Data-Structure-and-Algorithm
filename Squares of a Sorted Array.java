public class Squares of a Sorted Array {

  class Solution {
    public int[] sortedSquares(int[] nums) {



        ArrayList<Integer> res = new ArrayList<>();

        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            int p = nums[i] * nums[i];
            res.add(p);
        }



        Collections.sort(res);





        int[] ans = new int[res.size()];


        for(int i=0;i<res.size();i++)
        {
            ans[i] = res.get(i);
        }


        return ans;

        
    }
}
  
}
