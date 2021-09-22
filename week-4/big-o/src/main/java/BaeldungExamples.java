public class BaeldungExamples {

    /*
        The key to understanding Big O
        is understanding the rates at which
        things can grow.

        The rate here is time taken per input size.
     */
    public static void constantTime(int n) {
        System.out.println("Hey - your input is: " + n);
    }

    /*
        Below this algorithm is still constant time,
        despite taking three times as long to run.
        Constant time is described as follows: 0(1)
     */
    public static void otherConstantTime(int n) {
        System.out.println("Hey - your input is: " + n);
        System.out.println("Hmm... I'm doing more stuff with: " + n);
        System.out.println("One more time here... " + n);
    }

    /*
        Below describes logarithmic time
        This algorithm is the next best thing to constant time
        As the input gets larger, the efficiency is relatively stable
     */
    public static void logTime(int n) {
        for (int i = 1; i < n; i = i * 2) {
            System.out.println("Hey - I'm busy looking at: " + i);
        }
    }

    /*
        Below describes linear time
        meaning the algorithm grows proportionally to its input
     */
    public static void linearTime(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Hey - I'm busy looking at: " +  i);
        }
    }

    /*
        Below describes n log n
     */
    public static void nlogNTime(int n) {
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j = j * 2) {
                System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
            }
        }
    }


    // polynomial describes times that are quadratic (n^2), cubic (n^3), quartic (n^4)
    public static void quadraticTime(int n) {
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.println("Hey I'm busy looking at: " + i + " and " + j);
            }
        }
    }


    /*
        Below describes exponential time (0k^n)
        these algorithms grow in proportion to some factor exponentiated by the input size
     */
    public static void expoTime(int n) {
        for (int i = 1; i <= Math.pow(2, n); i++) {
            System.out.println("Hey - I'm busy looking at : " + i);
        }
    }

    /*
        Below describes factorial time O(n!)
     */
    public static void factTime(int n) {
        for (int i = 1; i <= factorial(n); i++) {
            System.out.println("Hey - I'm busy looking at: " + i);
        }
    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }

}
