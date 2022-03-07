import java.util.*;
import java.util.Arrays;
import java.util.Random;

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

    public static void randompick(String[] moves, char[][] protos, int y, int x) {
        for (int a = 0; a < 4; a++) {
            if (moves[a] == "down")  placer(protos, y - 1, x);
            if (moves[a] == "left")  placer(protos, y, x + 1);
            if (moves[a] == "up")    placer(protos, y + 1, x);
            if (moves[a] == "right") placer(protos, y, x - 1);
        }
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

        if (y == 0 || x == 0) return false; // out of bounds
        if (x == proto[0].length - 1 || y == proto.length - 1) return false; // out of bounds
        if (proto[y][x] == ' ') return false;

        return goodSpot(proto, y, x, temp); // empty spots around
    }

    public static void placer(char[][] proto, int y, int x) {
        if (badSpot(proto, y, x)) {

            String[] randomized = { "up","right",  "down",  "left" };

            Random rand = new Random();

            for (int i = 0; i < randomized.length; i++) {
                int rover = rand.nextInt(randomized.length);
                String temp = randomized[rover];
                randomized[rover] = randomized[i];
                randomized[i] = temp;
            }

            proto[y][x] = ' ';
            randompick(randomized, proto, y, x);
        }
    }


    
}
