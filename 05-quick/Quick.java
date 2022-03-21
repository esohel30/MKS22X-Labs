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




          int[] supa = {234,23,423,4,23,43,234,23,423,4,23,4,23,4,23,4,2,42,34,23,4,23,42,34,65,756,7,4,4,534,534,645,7,456,4,563,46,75,745,7,45,74,57,4,5,3,46,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-1,1,1,11,-1,1,5};

          quicksort(supa);

          System.out.print(Arrays.toString(supa));

          //EVERYTHING WORKS



        }

}
