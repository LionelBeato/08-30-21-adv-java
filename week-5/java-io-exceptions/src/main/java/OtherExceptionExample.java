import java.util.InputMismatchException;
import java.util.Scanner;

public class OtherExceptionExample {

    private static int divide() {
        int x = getInt();
        int y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number ");
        while(true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Error - please enter a number");
            }
        }
    }


    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);
    }

}
