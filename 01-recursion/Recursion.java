public class Recursion {

    /*Print all words that are made of the letters a-e inclusive.
     *@param length : the length of the words that are to be printed
     */
    public static void printAllWords(int length) {
        printAllWords(length, "");
    }

    /*Print all words that are made of the letters a-e inclusive.
     *@param length : either how many more letters or the total length depending on implementation
     *@param word   : the partial word so far.
     */

    public static void printAllWords(int length, String word) {
        if (length == 0) {
            System.out.println(word);
        } else {

            for (char a = 'a'; a <= 'e'; a++) {
                printAllWords(length - 1, word + a);
            }
        }
    }

    /*Print all words that are made of the characters in the array of letters.
     *There may not be consecutive equal letters, so:
     *aax is not allowed, but axa is allowed.
     *@param length : the length of the words that are to be printed
     *@param letters: the letters you should be using,
     *@precondition: letters contains at least 2 characters, and has no duplicates.
     */
    public static void printNoDoubleLetterWords(int length, char[] letters) {
        printNoDoubleLetterWords(length, "", letters);
    }

    /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
     *aax is not allowed, but axa is allowed.
     *@param length : either how many more letters need to be
     *@param word   : the partial word so far.
     *@param letters: the letters you should be using
     */
    public static void printNoDoubleLetterWords(int length, String word, char[] letters) {

        if (length == 0) {
            boolean duplicate = false;
            for (int i = 0; i < word.length() - 1; i++) {

                if (word.charAt(i) == word.charAt(i + 1)) {
                    duplicate = true;
                }
            }

            if (duplicate == false) {
                System.out.println(word);
            }

        } else {
            for (int i = 0; i < letters.length; i++) {

                printNoDoubleLetterWords(length - 1, word + letters[i], letters);

            }
        }
    }


    /*
     *@param s any string
     *@return a string that is the reversed version of s, do NOT use built in methods to do so, use recursion.
     */
    public static String reverse(String s) {
        if (s.length() < 2) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }



    /*
     *@param n any non-negative value you want to take the sqrt of
     *@return the approximate sqrt of n within a tolerance of 0.001%
     */
    public static double sqrt(double n) {
        return sqrt(n, 1);
    }

    public static double sqrt(double n, double guess) {
        if (Math.abs(guess * guess - n) <= 0.00001 * n) {
            return guess;
        } else {
            return sqrt(n, ((n / guess + guess) / 2));
        }
    }


    /*
    *@param length how long the words must be
    *param word the variable to store the partial solution (should start at "")
    *@return the number of words that have no adjacent matching letters using the letters a-z.
    *Repetition allowed except when letters are adjacent.
    */
    public static long countNoDoubleLetterWords(int length, String word) {
    //Hint: not a wrapper method, but you must call it starting with "" as your word.
    long sum = 0;

    if (length == 0) {
        boolean duplicate = false;
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                duplicate = true;
            }
        }
        if (duplicate == false) {
            return 1;
        }

    } else {

        for (char a = 'a'; a <= 'z'; a++) {
            sum += (countNoDoubleLetterWords(length - 1, word + a));
        }
    }

    return sum;
}

/*
            *@param n any non-negative value
            *@return the nth term of the fibonacci sequence. 0, 1, 1, 2, 3, 5 etc.
            */
            public static int fibIter(int n, int f1, int f2){
              //DO NOT call fibIter more than once

              if (n == 0){
              return f2;
              }
              if (n == 1){
              return f1;

              }else{
              return fibIter(n - 1, f1 + f2, f1);
            }
          }







    public static void main(String[] args) {
        // System.out.println(reverse("racecar"));
        // System.out.println(reverse("KONSTANTINOVICH"));
        // System.out.println(sqrt(35));
        // System.out.println(sqrt(34434));
        // System.out.println(countNoDoubleLetterWords(3,""));
        // System.out.println(countNoDoubleLetterWords(2,""));
        // System.out.println(countNoDoubleLetterWords(10,""));
        System.out.println(fibIter(0,1,0));
        System.out.println(fibIter(1,1,0));
        System.out.println(fibIter(2,1,0));
        System.out.println(fibIter(3,1,0));
        System.out.println(fibIter(4,1,0));
        System.out.println(fibIter(5,1,0));
        System.out.println(fibIter(6,1,0));
        System.out.println(fibIter(7,1,0));
        System.out.println(fibIter(8,1,0));
        System.out.println(fibIter(9,1,0));
        System.out.println(fibIter(10,1,0));
        System.out.println(fibIter(11,1,0));







    }

}
