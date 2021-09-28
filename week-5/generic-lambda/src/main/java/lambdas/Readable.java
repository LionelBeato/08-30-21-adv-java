package lambdas;

// here we are using the annotation functionalinterface
// this has no strict functionality but serves as documentation
// denoting that the interface is being used functionally
@FunctionalInterface
public interface Readable {

    // below we have what's known as a single abstract method
    // when an interface is used to create lambdas we can
    // simply define one method, and only one method,
    // to be later employed and simplified in our code
    void doRead();

}
