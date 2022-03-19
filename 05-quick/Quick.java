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
        System.out.println(piv);

        for (int i = lo + 1; i < hi + 1; i++) {
            if (data[i] <= data[lo]) {
                s(data, piv, i);
                piv++;
            }
        }

        s(data, piv - 1, lo);
        System.out.println(Arrays.toString(data));
        return piv - 1;
    }





    public static void main(String[] args) {
      partition( new int[] {4,3,2,1,0}, 0, 4);
      partition( new int[] {4,3,2,1,0,997,998,999}, 0, 4);
      partition( new int[] {997,998,999,4,3,2,1,0},3,7);
      partition( new int[] {993,994,995,4,3,2,1,0,997,998,999},3,7);
    }




}
