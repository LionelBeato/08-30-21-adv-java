package threads;

public class SleepMessages {

    // recall that our main method is our main thread
    // thus we can execute Thread methods within the scope of the main thread
    // note that we denote that the main methods throws InterruptedException
    // this stems from our use of the sleep method which can be interrupted
    // by another thread
    public static void main(String[] args) throws InterruptedException {

        // here we have an array of strings
        // that we want to print out
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too",
        };

        // an enhanced for loop that will invoke the static sleep method
        // causing our main thread to sleep for roughly 4 seconds
//        for (String info : importantInfo) {
//            Thread.sleep(4000);
//            System.out.println(info);
//        }

        for (String info: importantInfo) {
            // go ahead and pause for 4 seconds
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                // looks like we've been interrupted:
                // don't render anymore messages
                return;
            }
            System.out.println(info);
        }

    }

}
