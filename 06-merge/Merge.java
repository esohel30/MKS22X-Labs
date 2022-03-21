import java.util.Arrays;
public class Merge{

  public static int [] merge(int [] left, int[] right){
    int i = left.length + right.length -1;
    int[] temp = new int[i+1];
    int len1 =  left.length-1;
    int len2 = right.length-1;

    while(i != -1) {
      if(len1 > -1 && len2 == -1){
        temp[i] = left[len1];
        len1 --;
        i--;
      }
      if(len2 > -1 && len1 == -1){
        temp[i] = right[len2];
        len2 --;
        i--;
      }
      if(len1 > -1 && len2 > -1 && left[len1] >= right[len2]){
        temp[i] = left[len1];
        len1 --;
        i--;
      }
      if(len1 > -1 && len2 > -1 && left[len1] <= right[len2]){
        temp[i] = right[len2];
        len2 --;
        i--;
      }
    }
    return temp;
  }

  public static void main(String[] args) {
    int[] x = {1,2,3,4,5,6,7,8,9,10};
    int[] y = {11,12,13,14,15};
    System.out.println(Arrays.toString(merge(x,y)));


  }

}
