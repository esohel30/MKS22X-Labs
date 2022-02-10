public class codingbat{


  public static boolean groupSum(int start, int[] nums, int target) {

    if(target == 0){
      return true;
    }
    if(start == nums.length || target < 0){
      return false;

    }else{
      return (groupSum(start + 1, nums, target - nums[start])  || groupSum(start + 1, nums, target) );
    }
  }

  public static boolean splitArray(int[] nums) {


  }




  public static void main(String[] args) {
      System.out.println( groupSum(1, new int[]{2,4,8} , 12) );

   }





}
