package TwoPointer;

import java.util.Arrays;

public class MovesZeros {
    public void MoveZero(int[] nums)
    {
      int n = nums.length;
      int left =0;
      for(int right=0;right<n;right++)
      {
        if(nums[right]!=0)
        {
          int temp = nums[right];
          nums[right] = nums[left];
          nums[left]=temp;
          left++;
        }
      }

    }
    public static void main(String[] args)
    {
      
   int[] a ={1,2,3,0,0,8,6,0};
   MovesZeros obj = new MovesZeros();
   obj.MoveZero(a);
   System.out.println(Arrays.toString(a));



    }

  
}

//c:\Users\rkrk0\OneDrive\Pictures\Screenshots\Screenshot 2025-10-07 120505.png - photo for better understanding
