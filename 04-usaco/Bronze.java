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

    return 0;
  }





  public void stomp(char[][] pasture, int R_s, int C_s, int D_sl){
    int max = -1;
    for(int i =0; i < D_sl; i++){

      for(int a= R_s; a < R_s+4; a ++){
        for(int b = C_s; b < C_s + 4; b ++){
          if(pasture[a][b] > max){
            max = pasture[a][b];
          }
        }
    }

    System.out.println(max);
    }
  }



  public static void main(String[] args) {
    try{
      Bronze.solve("sampleInput2");


    }catch(FileNotFoundException e){
        System.out.println(e);
    }
  }




}
