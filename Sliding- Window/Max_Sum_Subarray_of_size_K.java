// geeksforGeeks
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        
        int low =0;
        int high =k-1;
        int sum =0;
        int result =0;
        int n = arr.length;
        if(n<k)
        return 0;
        
        for(int i=low;i<=high;i++)
        {
            sum += arr[i];
        }
        result = sum;
        
        while(high<n-1)
        {
            
            sum -= arr[low];
            low++;
            high++;
        sum += arr[high];
        result = Math.max(result , sum);
            
            
        }
        
        return result;
        
    }
}