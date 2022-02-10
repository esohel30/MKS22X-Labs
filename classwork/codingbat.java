public class codingbat{


  public boolean groupSum(int start, int[] nums, int target) {

    if(target == 0){
      return true;
    }
    if(start == nums.length){
      return false;

    }else{
      return (groupSum(start + 1, nums, target - nums[start])  || groupSum(start + 1, nums, target));
    }
  }





}
