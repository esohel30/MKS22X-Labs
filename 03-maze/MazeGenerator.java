import java.util.*;
public class MazeGenerator {

    public static void filler(char[][] proto) {
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

    public static boolean goodSpot(char[][] proto, int y, int x, int tot) {
        if (proto[y][x + 1] == ' ') tot += 1;
        if (proto[y + 1][x] == ' ') tot += 1;
        if (proto[y - 1][x] == ' ') tot += 1;
        if (proto[y][x - 1] == ' ') tot += 1;

        return (tot < 2);
    }

    public static boolean badSpot(char[][] proto, int y, int x) {
        int temp = 0;

        if (y == 0 || x == 0) return false;
        if (x == proto[0].length - 1 || y == proto.length - 1) return false;
        if (proto[y][x] == ' ') return false;

        return goodSpotCheck(proto, y, x, temp);
    }


  }
