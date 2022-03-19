import java.util.Arrays;

public class Quick {

    public static void s(int[] data, int a, int b) { //swaps two indexes of an array
        int shift = data[a];
        data[a] = data[b];
        data[b] = shift;
    }


    public static int partition(int[] data, int lo, int hi) {
        s(data, (int)(Math.random() * ((hi + 1) - lo) + lo), lo);
        int piv = lo + 1;

        for (int i = lo + 1; i < hi + 1; i++) {
            if (data[i] <= data[lo]) {
                s(data, piv, i);
                piv++;
            }
        }

        s(data, piv - 1, lo);
        return piv - 1;
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



    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,};
        quicksort(a);
        System.out.print(Arrays.toString(a));
        
          partition( new int[] {4,3,2,1,0}, 0, 4);
          partition( new int[] {4,3,2,1,0,997,998,999}, 0, 4);
          partition( new int[] {997,998,999,4,3,2,1,0},3,7);
          partition( new int[] {993,994,995,4,3,2,1,0,997,998,999},3,7);

          int[] ary = {2, 10, 15, 23, 0, 5};
          System.out.println(  quickselect(ary , 0 )); // SHOULD RETURN0
          System.out.println(  quickselect( ary , 1 ));// SHOULD RETURN2
          System.out.println(  quickselect( ary , 2 ));// SHOULD RETURN5
          System.out.println(  quickselect( ary , 3 ));// SHOULD RETURN10
          System.out.println(  quickselect( ary , 4 ));// SHOULD RETURN15
          System.out.println(  quickselect( ary , 5 ));// SHOULD RETURN23

          //EVERYTHING WORKS



        }

}
