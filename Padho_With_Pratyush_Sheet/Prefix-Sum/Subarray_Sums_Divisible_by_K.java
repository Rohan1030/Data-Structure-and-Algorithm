//     Leetcode :- 974 
// Subarray Sums Divisible by K

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer , Integer> map = new HashMap<>();
        int count =0;

        map.put(0,1);
        int prefixSum =0;

        for(int num:nums)
        {
            prefixSum += num;
            int rem = prefixSum % k;
            if(rem<0)
            {
                rem +=k;
            }
            if(map.containsKey(rem))
            {
                count += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
        
        
    }
}