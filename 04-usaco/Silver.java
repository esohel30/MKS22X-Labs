import java.util.*;
import java.io.*;

public class Silver {
    public static long solve(String filename) {

        try {
            File texter = new File(filename);
            Scanner input = new Scanner(texter);

            int N, M, T;
            char[][] pasture;
            int R1, C1, R2, C2;

            N = input.nextInt();
            M = input.nextInt();
            T = input.nextInt();
            pasture = new char[N][M];

            for (int i = 0; i < N; i++) {
                String x = input.next();
                for (int j = 0; j < M; j++) {
                    pasture[i][j] = x.charAt(j);
                }
            }

            R1 = input.nextInt();
            C1 = input.nextInt();
            R2 = input.nextInt();
            C2 = input.nextInt();


            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    System.out.print(pasture[a][b] + " ");
                }
                System.out.print("\n");

            }


            return 1;
        } catch (FileNotFoundException e) {
            return -1;
        }
    }


    public static void main(String[] args) {
        solve("ctravel.1.in");
    }



}
