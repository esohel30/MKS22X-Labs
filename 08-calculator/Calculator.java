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

        if(s.length() == 0){
          throw new IllegalArgumentException("too few operands");
        }

        Scanner x = new Scanner(s);
        ArrayDeque<Double> data = new ArrayDeque<Double>();

        while(x.hasNext()){
          String temp = x.next();
          Double a;
          Double b;

          if(temp.equals("+")) {
             checkSize(data);
             a = data.removeLast();
             b = data.removeLast();
            data.add(a + b);
          }

          else if(temp.equals("-")){
            checkSize(data);
             a = data.removeLast();
             b = data.removeLast();
            data.add(b - a);
          }

          else if(temp.equals("*")){
            checkSize(data);
             a = data.removeLast();
             b = data.removeLast();
            data.add(a * b);
          }

          else if(temp.equals("/")){
            checkSize(data);
             a = data.removeLast();
             b = data.removeLast();
            data.add(b / a);
          }

          else if(temp.equals("%")){
            checkSize(data);
             a = data.removeLast();
             b = data.removeLast();
             data.add(b % a);
          }

          else{
            data.add(Double.parseDouble(temp));
          }
        }

          if(data.size() > 1){
            throw new IllegalArgumentException("too many operands");
          }
          return data.getFirst();
      }

      public static void checkSize(ArrayDeque<Double> x){
        if(x.size() < 2){
          throw new IllegalArgumentException("too few operands");
        }
      }

    }
