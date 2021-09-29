public class Main {

    // below is our entrypoint
    // it is how we start our application
    // your main method is in fact also the main thread
    // the main thread as the ability to create additional threads
    public static void main(String[] args) {
        // below we are instantiating a new thread
        // and passing in a new instance of HelloRunnable
        // HelloRunnable is of type Runnable which is one of the
        // objects that your thread will need to execute
        new Thread(new HelloRunnable()).start();
        // below we are instantiating a subclass of Thread
        // that is overriding its own run method
        new HelloThread().start();

        // bear in mind that Runnable is a functional interface
        // which means we can use it as a lambda expression
        // while at first this may seem a little hard to parse
        // it is arguably cleaner, neater and more readable
        new Thread(() -> System.out.println("Hello from a lambda runnable! ")).start();
    }

}
