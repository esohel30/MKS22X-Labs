import java.util.*;
import java.io.*;

public class Silver{
  private int N, M, T;
  private char[][] pasture;
  private int R1, C1, R2, C2;


  public Silver(String filename) throws FileNotFoundException{
    File texter = new File(filename);
    Scanner input = new Scanner(texter);

    N = input.nextInt();
    M = input.nextInt();
    T = input.nextInt();
    pasture = new char[N][M];

    for(int i = 0; i < N; i ++){
      String x = input.next();
      for(int j = 0; j < M; j++){
        pasture[i][j] = x.charAt(j);
      }
    }

      R1 = input.nextInt();  C1 = input.nextInt();
      R2 = input.nextInt();  C2 = input.nextInt();

    }





  public static void main(String[] args) {
    try{
      Silver x = new Silver("sampleInput");


    }catch(FileNotFoundException e){
        System.out.println(e);
    }
  }








}
