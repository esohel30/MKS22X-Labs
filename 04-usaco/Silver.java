import java.util.*;
import java.io.*;

public class Silver {

    public static long solve(String filename) {

        try {
            File texter = new File(filename);
            Scanner input = new Scanner(texter);

            int N, M, T;
            int[][] pasture;
            char[][] moov;
            int R1, C1, R2, C2;
            N = input.nextInt();
            M = input.nextInt();
            T = input.nextInt();
            pasture = new int[N][M];
            moov = new char[N][M]; // get it moooooooooo v hahaha

            //fill in moov with array values
            for (int a = 0; a < N; a++) {
                String holder = input.next();
                for (int b = 0; b < M; b++) {
                    moov[a][b] = holder.charAt(b);
                }
            }

            R1 = input.nextInt();  C1 = input.nextInt();
            R2 = input.nextInt();  C2 = input.nextInt();

            pasture[R1 - 1][C1 - 1] = 1;

          
    }

    private static boolean isG(char[][] moov, int N, int M) {
        if (moov[N][M] == '.') {
            return true;
        }
        if (moov[N][M] == '*') {
            return false;
        }
        return false;
    }

    private static boolean isIn(int N, int M, int row, int col) {
        return (N > -1 && N < row && M > -1 && M < col);
    }


    private static void placer(int[][] rep, int r, int c, int N, int M, int[][] farm, char[][] moov) {
        //clockwise

        if (isIn(N, M - 1, r, c) && isG(moov, N, M - 1)) {
            rep[N][M] += farm[N][M - 1]; //up
        }
        if (isIn(N + 1, M, r, c) && isG(moov, N + 1, M)) {
            rep[N][M] += farm[N + 1][M]; //right
        }
        if (isIn(N, M + 1, r, c) && isG(moov, N, M + 1)) {
            rep[N][M] += farm[N][M + 1]; //down
        }
        if (isIn(N - 1, M, r, c) && isG(moov, N - 1, M)) {
            rep[N][M] += farm[N - 1][M]; //left
        }
    }

    public static void main(String[] args) {
        System.out.print(solve("ctravel.2.in"));
    }

}
