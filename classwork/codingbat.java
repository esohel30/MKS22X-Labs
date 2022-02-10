public class codingbat{


  public static boolean groupSum(int start, int[] nums, int target) {

    if(target == 0){
      return true;
    }
    if(start == nums.length || target < 0){
      return false;

    }else{
      //choose or dont choose
      return (groupSum(start + 1, nums, target - nums[start])  || groupSum(start + 1, nums, target) );
    }
  }

  public static boolean splitArray(int[] nums) {
  }

    public static boolean part(int[] nums, int index, int a, int b ){
      if(nums.length  == index){
        return a == b;

        

    }






  public static void main(String[] args) {
      System.out.println( groupSum(1, new int[]{2,4,8} , 12) );
      System.out.println( splitArray(new int[] {1,2,3,5}));
   }





}
