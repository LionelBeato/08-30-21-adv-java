public class GreetNeighbor {

    public static void sayHelloNeighbor(String greeting) throws SayProperGreetingException {
        if (greeting.equalsIgnoreCase("Hello")) {
            System.out.println(greeting + " neighbor! Welcome!");
        } else {
            throw new SayProperGreetingException(greeting);
        }
    }

    public static void main(String[] args) throws SayProperGreetingException {
        sayHelloNeighbor("hello");
    }

}
