import java.util.ArrayDeque;
import java.util.Scanner;


public class Calculator{
      /*Evaluate a postfix expression stored in s.
      *Assume valid postfix notation, of ints doubles and operators separated by spaces.
      *Valid operators are + - / * and % (remainder not modulo)
      *All results are doubles even if the operands are both int.
      *@throws IllegalArgumentException when there are too many or too few operands.
      *        Use the string parameter of your exception to indicate what happened.
      *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
      */
      public static double eval(String s){

        Scanner x = new Scanner(s);

        while(x.hasNext()){
        System.out.println(x.next());
      }



        return 1.0;

      }

      public static void main(String[] args) {
        ArrayDeque<String> x = new ArrayDeque<String>(16);
        x.add("hello");
        x.add("hello");
        x.add("hello");
        x.add("hello");

        eval("hello good bye hello good bye ");


        //System.out.print(x);



      }

    }
