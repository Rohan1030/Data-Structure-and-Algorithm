
// 🧩 Problem: Find Floor and Ceil in a Sorted Array
// 🔹 Given:

// A sorted array of integers (in ascending order) and a target value.

// 🔹 Task:

// You need to find:

// Floor → the largest element in the array that is less than or equal to the target.

// Ceil → the smallest element in the array that is greater than or equal to the target.

// If the floor or ceil does not exist (for example, when the target is smaller than the smallest element or greater than the largest element), return -1 for that value.







package BinarySearch;
class FloorCeilinSortedArray
{
  public static void main(String[] args)
  {
    int[] nums = {1,2,4,6,12,14,16,18};
    int target = 15;

    int Floor = floor(nums,target);
    int Ceilin = ceilin(nums, target);
    System.out.println(Floor);
    System.out.println(Ceilin);

  }




  private static int floor(int[] nums , int target)
  {
    int n = nums.length;
    int left=0;
    int right=n-1;
    int Floor=-1;
    while(left<=right)
    {
      int mid = left+(right-left)/2;
      if(nums[mid]==target)
      {
        return nums[mid];
      }
      else if(target>nums[mid])
      {
        left=mid+1;
        Floor=nums[mid];
      }
      else 
      {
        right=mid-1;
      }

    }
    return Floor;


  }

  private static int ceilin(int[] nums, int target)
  {
    int n = nums.length;
    int left=0;
    int right=n-1;
    int Ceilin = -1;

    while(left<=right)
    {
      int mid = left+(right-left)/2;
      if(nums[mid]==target)
      {
        return nums[mid];
      }
      else if(target>nums[mid])
      {
        left=mid+1;
      }
      else 
      {
        right = mid-1;
        Ceilin = nums[mid];
      }
    }


return Ceilin;

  }
  
}