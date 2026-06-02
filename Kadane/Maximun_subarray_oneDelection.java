//leetcode - 1186
package Kadane;

class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int nodelete = arr[0];
        int onedelete = 0;
        int ans = arr[0];


        for(int i=1;i<n;i++)
        {
            nodelete = Math.max(nodelete , nodelete + arr[i]);
            
            onedelete = Math.max(nodelete , onedelete + arr[i]);

        ans = Math.max( ans , Math.max(nodelete , onedelete));

        
    }
    return ans;
}
}
