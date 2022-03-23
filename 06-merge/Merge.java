import java.util.Arrays;
public class Merge {
    /*merge takes two sorted arrays and returns a new array that combines all
     *elements of both arrays in asorted order.
     *@left a sorted array (this is a precondition)
     *@right a sorted array (this is a precondition)
     *@return a sorted array that contains all elements of left and right
     */
    public static int[] merge(int[] left, int[] right) {

        int i = left.length + right.length - 1;
        int[] temp = new int[i + 1];
        int len1 = left.length - 1;
        int len2 = right.length - 1;

        while (i != -1) {

            if (len1 > -1 && len2 == -1) {
                temp[i] = left[len1];
                len1--;
                i--;
            }
            if (len2 > -1 && len1 == -1) {
                temp[i] = right[len2];
                len2--;
                i--;
            }
            if (len1 > -1 && len2 > -1 && left[len1] >= right[len2]) {
                temp[i] = left[len1];
                len1--;
                i--;
            }
            if (len2 > -1 && len1 > -1 && left[len1] <= right[len2]) {
                temp[i] = right[len2];
                len2--;
                i--;
            }

        }
        return temp;
    }

    /*mergesortH is the actual mergesort method.
     *@data the array to be sorted
     *@return a new array that is the sorted version of data.
     */
    public static int[] mergesortH(int[] data) {

        int len = data.length;
        int half = data.length / 2;
        int[] left = new int[half];
        int[] right = new int[len - half];

        if (data.length == 1) {
            return data;
        }

        if (data.length > 1) {

            for (int i = 0; i < half; i++) {
                left[i] = data[i];
            }
            for (int j = 0; j < len - half; j++) {
                right[j] = data[j + half];
            }

        }
        return merge(mergesortH(left), mergesortH(right));
    }

    /*mergesort uses the recursive mergesortH method to create a sorted
     *version of the array. It then copies the data back into the original
     *array. (This is for compatibility with prior sort testers)
     *@param data the array to be sorted, this will be modified by the method
     */

     //this makes code so slow 
    public static void mergesort(int[] data) {
        int[] temp = mergesortH(data);
        for (int i = 0; i < data.length; i++) {
            data[i] = temp[i];
        }

    }

}
