import java.util.*;
import java.io.*;

public class Bronze{

  public static long solve(String filename) throws FileNotFoundException {
    int R, C, E, N;
    int[][] pasture;
    int R_s, C_s, D_sl;

    File texter = new File(filename);
    Scanner input = new Scanner(texter);
    R = input.nextInt();
    C = input.nextInt();
    E = input.nextInt();
    N = input.nextInt();

    pasture = new int [R][C];

    for(int i = 0; i < R; i++){
      for(int j = 0; j < C; j++){
        pasture[i][j] = input.nextInt();
      }
    }

    for(int z =0; z < N; z ++){
      stomp(pasture, input.nextInt(), input.nextInt(), input.nextInt());
    }

    int tot =0;
    for(int v = 0; v < R; v++){
      for(int m = 0; m < C; m ++){
        pasture[v][m] = E - pasture[v][m];
        if(pasture[v][m] > 0){
          tot+= pasture[v][m];
        }
      }
    }

    return tot * (6*12) * (6*12);
  }


  public static void stomp(int[][] pasture, int R_s, int C_s, int D_sl){

    for(int i =0; i < D_sl; i++){
      int max = -1;

      for(int a = R_s -1; a < R_s +2; a ++){
        for(int b = C_s -1; b < C_s + 2; b ++){
          if(pasture[a][b] > max){
            max = pasture[a][b];
          }
        }
      }

      for(int d = R_s -1; d < R_s +2; d ++){
        for(int e = C_s -1; e < C_s + 2; e ++){
          if(pasture[d][e] == max){
            pasture[d][e] --;
          }
        }
      }
    }
  }



  public static void main(String[] args) {
    try{
      System.out.print(Bronze.solve("sampleInput2"));


    }catch(FileNotFoundException e){
        System.out.println(e);
    }
  }




}
