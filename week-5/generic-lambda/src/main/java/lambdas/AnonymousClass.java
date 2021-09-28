package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface CalculateExponent {
    int run(int x);
}

public class AnonymousClass {

    public static void getExponent(int x, CalculateExponent exponentFunction) {
        int result = exponentFunction.run(x);
        System.out.println(result);
    }

    public static CalculateExponent exponent(CalculateExponent calculateExponent) {
        return calculateExponent;
    }

    public static void main(String[] args) {

        // below is a simple use of an anonymous class
        // here we are extending our book class and overriding
        // the behavior of "getTitle"
        Book myBook = new Book("The Fisherman") {
            @Override
            public String getTitle() {
                return "this is my book title: " + super.getTitle();
            }
        };

        // this instance is not extending the original book class
        // and thus is not going to override any behaviors
        Book otherBook = new Book("Green Eggs and Ham");

        System.out.println(myBook.getTitle());
        System.out.println(otherBook.getTitle());

        Readable myReadable = new Readable() {
            @Override
            public void doRead() {
                System.out.println("I am reading a book!");
            }
        };

        Readable functionalReadable = () -> System.out.println("I am reading a comic book");
        functionalReadable.doRead();

        LambdaExample myLambda = (x, y) -> System.out.println(x + " " + y);
        myLambda.function(3, 5);

        LambdaExample addLambda = (x, y) -> System.out.println(x + y);
        addLambda.function(3, 5);

        List<String> students = new ArrayList<>();
        students.add("Bob");
        students.add("Karen");
        students.add("Jimmy");

        // here we are using a higher order function
        // known as forEach that behaves like a for loop
        // this higher order function accepts a lambda that
        // performs an action on each and every element in our collection
        students.forEach((student) -> System.out.println(student));


        // a traditional functional way of filtering a collection
        // invoking the "filter" method
        // the lambda in the filter has to resolve to "true"
        // in order for the given element to be filtered through
        students.stream()
                .filter(student -> student.charAt(0) == 'J')
                .forEach(student -> System.out.println(student));

        // less idiomatic way of filtering using imperative conditional logic
        students.forEach(student -> {
            if (student.charAt(0) == 'J') {
                System.out.println(student);
            }
        });

        IntegerMath addition = (a, b) -> {
            // if you use curly braces for your lambda body
            // you need to use the keyword return if you intend
            // on returning a meaningful value
            return a + b;
        };

        IntegerMath substraction = (a, b) -> a - b;
        System.out.println(addition.operation(5,5));
        System.out.println(substraction.operation(5, 3));

        CalculateExponent squareNumber = (x) -> x * x;
        getExponent(5, squareNumber);
        getExponent(5, (x) -> x * x * x);

        // Function interface/type

        List<Integer> integers = List.of(1,2,3,4,5);
        Function<Integer, Long> myFunction = (x) -> Long.valueOf(x);
        integers.stream()
                .map(myFunction)
                .forEach(element -> System.out.println(element));

        // method reference
        // below is a method reference
        // this simplifies some method calls in lambdas
        // if its obvious what the input for the given method will be
        integers.stream()
                .forEach(System.out::println);


        List<Person> people = List.of(
                new Person("Bob", 34),
                new Person ("Jerry", 67),
                new Person ("Delilah", 26)
        );

        // below is the culmination of the functional style of programming
        // in java, here instead of relying on lambdas, we simply invoke
        // methods with a method reference, thus allowing us to write less
        // code that's ultimately less error-prone
        people.stream()
                .map(Person::getName)
                .forEach(System.out::println);
    }
}
