import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // here is an example of a basic standard output
        System.out.println("Hello world!");
        System.out.println("Type some stuff: ");

        // below is an example of a typical standard input
        Scanner scanner = new Scanner(System.in);
        String myText = scanner.nextLine();

        System.out.println("Here is what you typed: " + myText);


    }

}
