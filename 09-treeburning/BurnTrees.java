import java.util.*;
import java.util.ArrayDeque;
public class BurnTrees {
    private int[][] map;
    private int ticks;
    private static final int TREE = 2;
    private static final int FIRE = 1;
    private static final int ASH = 3;
    private static final int SPACE = 0;
    private ArrayDeque < int[] > frontier;


    /*Determine if the simulation is still burning
     *@return false if any fires are still burning, true otherwise
     */
    public boolean done() {
        //YOU MUST IMPLEMENT THIS
        return frontier.size() == 0;
    }


    /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
     *All existing fires spread new fires, and turn to ash
     *new fires should remain fire, and not spread.
     */
    public void tick() {
        ArrayDeque < int[] > temp = new ArrayDeque < > ();
        ticks++;


    }


    //helper method that checks if the fires are inbound

    public boolean inB(int index) {
        return (index >= 0 && index < map.length);
    }

    //helper method that checks for up down left right and if they are trees that are burnable

    public boolean isT(String Direction, int[][]
        var, int[] temp) {
        //up
        //tree is 2
        int row;
        int col;

        if (Direction.equals("up")) {
            row = temp[0];
            col = temp[1] + 1;
            return var [row][col] == 2;
        }
        //down
        if (Direction.equals("down")) {
            row = temp[0];
            col = temp[1] - 1;
            return var [row][col] == 2;

        }
        if (Direction.equals("right")) {
            row = temp[0] + 1;
            col = temp[1];
            return var [row][col] == 2;
        }
        if (Direction.equals("left")) {
            row = temp[0] - 1;
            col = temp[1];
            return var [row][col] == 2;
        }
        return false;
    }

  

    public BurnTrees(int width, int height, double density) {
        map = new int[height][width];
        frontier = new ArrayDeque < > ();
        for (int r = 0; r < map.length; r++)
            for (int c = 0; c < map[r].length; c++)
                if (Math.random() < density)
                    map[r][c] = 2;
        start(); //set the left column on fire.
    }

    /*
     *Sets the trees in the left column of the forest on fire
     */
    public void start() {
        //If you add more instance variables you can add more here,
        //otherwise it is complete.
        for (int i = 0; i < map.length; i++) {
            if (map[i][0] == TREE) {
                map[i][0] = FIRE;
                frontier.add(new int[] {i,0} );
            }
        }
    }



    public static void main(String[] args) {
        int WIDTH = 20;
        int HEIGHT = 20;
        int DELAY = 200;
        double DENSITY = .7;
        if (args.length > 1) {
            WIDTH = Integer.parseInt(args[0]);
            HEIGHT = Integer.parseInt(args[1]);
            DENSITY = Double.parseDouble(args[2]);
        }
        if (args.length > 3) {
            DELAY = Integer.parseInt(args[3]);
        }
        BurnTrees b = new BurnTrees(WIDTH, HEIGHT, DENSITY);


        int ans = b.animate(DELAY); //animate all screens
        System.out.println(ans); //print the final answer

        //int ans = b.outputAll();//print all screens one after another
        //System.out.println(ans);//print the final answer
    }



    /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

    /*DO NOT UPDATE THIS
     *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
     */
    public int run() {
        while (!done()) {
            tick();
        }
        return getTicks();
    }


    /*DO NOT UPDATE THIS*/
    public int getTicks() {
        return ticks;
    }

    /*DO NOT UPDATE THIS*/
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int c = 0; c < map[i].length; c++) {
                if (map[i][c] == SPACE)
                    builder.append(" ");
                else if (map[i][c] == TREE)
                    builder.append("@");
                else if (map[i][c] == FIRE)
                    builder.append("w");
                else if (map[i][c] == ASH)
                    builder.append(".");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /*DO NOT UPDATE THIS*/
    public String toStringColor() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int c = 0; c < map[i].length; c++) {
                if (map[i][c] == 0)
                    builder.append(" ");
                else if (map[i][c] == 2)
                    builder.append(Text.color(Text.GREEN) + "@");
                else if (map[i][c] == 1)
                    builder.append(Text.color(Text.RED) + "w");
                else if (map[i][c] == 3)
                    builder.append(Text.color(Text.DARK) + ".");
            }
            builder.append("\n" + Text.RESET);
        }
        return builder.toString() + ticks + "\n";
    }

    /*DO NOT UPDATE THIS*/
    public int animate(int delay) {
        System.out.print(Text.CLEAR_SCREEN);
        System.out.println(Text.go(1, 1) + toStringColor());
        Text.wait(delay);
        while (!done()) {
            tick();
            System.out.println(Text.go(1, 1) + toStringColor());
            Text.wait(delay);
        }
        return getTicks();
    }

    /*DO NOT UPDATE THIS*/
    public int outputAll() {
        System.out.println(toString());
        while (!done()) {
            tick();
            System.out.println(toString());
        }
        return getTicks();
    }


}
