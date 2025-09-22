

// TwoSum Problem 

package TwoPointer;

public class TwoSum {

public static  int[] twoSum(int[] Number , int target)
{
  int n = Number.length;
  int left = 0;
  int right = n-1;
  while(left < right)
  {
    int sum = Number[left] + Number[right];
    if(sum==target)

    {
      return new int[] {left+1, right+1};
    }
    else if (sum<target)
    {
      left++;
    }
    else 
    {
      right--;
    }


  }
  return new int[] {-1,-1};



}




  public static void main(String[] args) {

    int[] arr = {1,3,2,4,5,8};
    int target = 5;
    int[] result = twoSum(arr,target);
      if (result[0] != -1) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found!");
        }
    
  }
  
}


