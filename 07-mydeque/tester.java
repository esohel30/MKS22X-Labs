import java.util.Arrays;

public class tester {
  public static void main(String[] args) {
    MyDeque<Integer> test = new MyDeque<Integer>(5);
    System.out.println(test);


    for(int i =0; i < 100; i ++){
      test.addFirst(100 - i);
    }

    for(int i =0; i < 50; i ++){
      test.removeFirst();
    }





    System.out.println(test);
    System.out.println(Arrays.toString(test.data));
  }
}
