public class codingbat{


  public static boolean groupSum(int start, int[] nums, int target) {

    if(target == 0){
      return true;
    }
    if(start == nums.length){
      return false;

    }else{
      return (groupSum(start + 1, nums, target - nums[start])  || groupSum(start + 1, nums, target) );
    }
  }


  public static void main(String[] args) {

      System.out.println( groupSum(1, new int[]{2,4,8} , 12) );
      System.out.println( groupSum(0, new int[]{12,23,23,23,23,23,23} , 46) );
      System.out.println( groupSum(1, new int[]{212,4,8} , 11) );
      System.out.println( groupSum(1, new int[]{2,4,238} , 244) );
      System.out.println( groupSum(1, new int[]{2,423,8} , 1112) );

   }





}
