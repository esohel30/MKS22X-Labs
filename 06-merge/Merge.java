import java.util.Arrays;
public class Merge{

  public static int [] merge(int [] left, int[] right){
    int i = left.length + right.length -1;
    int[] temp = new int[i+1];
    int len1 =  left.length-1;
    int len2 = right.length-1;

    while(len1 != 0 && len2 != 0) {

      if(len1 > 0 && len2 == 0){
        temp[i] = left[len1];
        len1 --;
        i--;
      }

      if(len2 > 0 && len1 == 0){
        temp[i] = right[len2];
        len2 --;
        i--;
      }

      if(left[len1] >= right[len2]){
        temp[i] = left[len1];
        len1 --;
        i--;
      }
      if(left[len1] <= right[len2]){
        temp[i] = right[len2];
        len2 --;
        i--;
      }


    }

    return temp;

  }

  public static void main(String[] args) {
    int[] x = {1,2,3,4,5};
    int[] y = {1,2,3,4,5};
    System.out.println(Arrays.toString(merge(x,y)));


  }

}
