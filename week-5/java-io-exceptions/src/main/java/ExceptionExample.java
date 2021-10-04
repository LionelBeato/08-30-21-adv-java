public class ExceptionExample {

    public static void main(String[] args) {

        // here we have a try block
        // this code will be attempted but is denoted
        // as having the possibility of throwing an exception
        try {
            System.out.println("Hello world, lemme do something...");
            throw new Exception();
            // any code below where the exception is explicitly thrown
            // is considered unreachable
//            System.out.println("Can you read this code?");
        } catch (Exception e) {
            System.out.println("Looks like an exception was thrown :(");
            e.printStackTrace();
        } finally {
            System.out.println("This statement will always be seen!");
        }

    }
}
