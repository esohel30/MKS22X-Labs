import java.util.Arrays;

public class Quick {

    public static void switc(int[] data, int a, int b){ //switchs two indexes of an array
        int shift = data[a];
        data[a] = data[b];
        data[b] = shift;
    }


    public static int partition(int[] data, int start, int end) {

       switc(data, (int)(Math.random() * ((end + 1) - start) + start), start);
       int len = data.length - 1;
       int piv = start;
       int count = 0;


       while (piv < end && piv + 1 != len){

           if (data[piv + 1] < data[piv]) {
               switc(data, piv + 1, piv);
               piv++;
           }
           else if (data[piv + 1] > data[piv]) {
               switc(data, piv + 1, end);
               end--;
           }
           else if (data[piv + 1] == data[piv]) {
               if (count % 2 == 0) {
                   switc(data, piv, piv + 1);
                   piv++;
                   count++;
               }
               else {
                   switc(data, end, piv + 1);
                   end--;
                   count++;
              }
           }
       }
       return piv;
   }


    public static int quickselect(int[] arr, int k) {
        return quickselect(arr, k, 0, arr.length - 1);
    }

    public static int quickselect(int[] arr, int k, int lo, int hi) {
        int temp = partition(arr, lo, hi);
        if (temp == k) {
            return arr[k];
        }
        if (temp > k) {
            return quickselect(arr, k, lo, temp - 1);
        }
        return quickselect(arr, k, temp + 1, hi);
    }

    public static void quicksort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int ph = partition(arr, lo, hi);
            quicksort(arr, lo, ph - 1);
            quicksort(arr, ph + 1, hi);
        }
    }

    public static void quicksort(int[] data) {
        quicksort(data, 0, data.length - 1);
    }

}
