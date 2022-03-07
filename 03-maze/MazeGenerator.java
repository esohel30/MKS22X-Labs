import java.util.*;

public class MazeGenerator {

    public static void filler(char[][] proto){
      for (int i = 0; i < proto.length; i++) {
          for (int j = 0; j < proto[0].length; j++) {
              proto[i][j] = '#';
          }
      }
    }

    public static String toString(char[][] prototype) {
        String temp = "";
        for (int a = 0; a < prototype.length; a++) {
            for (int b = 0; b < prototype[a].length; b++) {
                temp += prototype[a][b];
            }
            if (a != prototype.length - 1) {
                temp = temp + "\n";
            }
        }
        return temp;
    }


  
}
