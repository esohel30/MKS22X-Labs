import java.util.*;
import java.io.*;

public class Maze {
    private char[][] maze = new char[0][0];
    private boolean animate; //false by default
    private int startRow, startCol;

    /*Constructor loads a maze text file, and sets animate to false by default.
    When the file is not found then:
    throw a FileNotFoundException

    You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
    '#' - Walls - locations that cannot be moved onto
    ' ' - Empty Space - locations that can be moved onto
    'E' - the location of the goal if any (0 or more per file)
    'S' - the location of the start(exactly 1 per file)

    You may also assume the maze has a border of '#' around the edges.
    So you don't have to check for out of bounds!
    Some text editors always include a newline at the end of a file, but that is not always present.
    Make sure your file reading is able to handle this.
    */
    public Maze(String filename) throws FileNotFoundException {
        String info = "" ;
        File text = new File(filename);
        Scanner input = new Scanner(text);
        ArrayList<String> values = new ArrayList<String>();

        while(input.hasNextLine()){
          String temp = input.nextLine();
          info += temp + "\n";
          values.add(temp);
        }
        maze = new char[values.size()][values.get(0).length()];
        for(int a =0; a < maze.length; a++){
          for(int b = 0; b < maze[a].length; b++){
              maze[a][b] = values.get(a).charAt(b);
              if(maze[a][b] == 's'){
                startRow = a;
                startCol = b;
              }
          }
    }
      System.out.println(a);
      System.out.println(b);
      setAnimate(false);
  }

    private void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }

    public void setAnimate(boolean b) {
        animate = b;
    }

    public static void clearTerminal() {
        //erase terminal
        System.out.println("\033[2J");
    }
    public static void gotoTop() {
        //go to top left of screen
        System.out.println("\033[1;1H");
    }

    /*Return the string that represents the maze.
    It should look like the text file with some characters replaced.
    */
    public String toString() {
        String temp = "";
        for(int a =0; a < maze.length; a ++){
          for(int j =0; j < maze[a].length; j++){
              temp += (maze[a][j]);
          }
          if(a != maze.length -1){
            temp = temp + "\n";
          }
        }
        return temp;
    }

    /*Wrapper Solve Function returns the helper function
    Note the helper function has the same name, but different parameters.
    Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve() {
        //only clear the terminal if you are running animation
        if (animate){
            clearTerminal();
        }
        //start solving at the location of the s.
        return solve(startRow, startCol);
    }

    /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.

    Postcondition:
    The 'S' is replaced with '@'
    The 'E' remain the same
    All visited spots that were not part of the solution are changed to '.'
    All visited spots that are part of the solution are changed to '@'
    */

    private int solve(int row, int col) { //you can add more parameters since this is private
        //automatic animation! You are welcome.
        if (animate) {
            gotoTop();
            System.out.println(this);
            wait(50);
        }

        if(maze[row][col] == 'E') {
          return 0;
        }
        if(maze[row][col] == '#'){
          return -1;
        }
        else{
          int down  = 0;
          int left  = 0;
          int up    = 0;
          int right = 0;

          down = solve(row+1, col);
          if(down >= 0){
            return down+1;
          }
          left = solve(row, col-1);
          if(left >= 0){
            return left+1;
          }
          up = solve(row-1, col);
          if(up >= 0){
            return up+1;
          }
          right = solve(row, col+1);
          if(right >= 0){
            return right +1;
          }
          maze[row][col] = '.';

        }
        //COMPLETE SOLVE
        return -1; //so it compiles
    }


    public static void main(String[] args) {
      try {
        Maze x = new Maze("maze1");
        System.out.print(x.solve());
      }
      catch(FileNotFoundException e){
        System.out.print(e);
      }
    }
}
