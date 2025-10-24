package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
  public static void main(String[] args) {
   int[] stalls = {1, 2, 4, 8, 9};
    int cows = 3;
    System.out.println(maxDistance(stalls, cows));
    
  }



  
  public static int maxDistance(int[] stalls , int cows)
  {
      Arrays.sort(stalls);
     
    int left = 1;
    int right = stalls[stalls.length-1]-stalls[0];
    int ans =0;
  
    
    while(left<=right)
    {
      int mid = left +(right-left)/2;
      if(canPlaceCows(stalls, cows, mid))
      {
        ans = mid;
        left = mid+1;
      }
      else 
      {
        right = mid-1;
      }

    }
    return ans;



  }

  private static boolean canPlaceCows(int[] stall,int cows , int distance)
  {
    int count =1;
    int lastPos = stall[0];


    for(int i=0;i<stall.length;i++)
    {
      if(stall[i]-lastPos >=distance)
      {
        count++;
        lastPos = stall[i];
      }
      if(count>=cows)
      return true;
    }

    return false;
  }


}
