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

    


}
