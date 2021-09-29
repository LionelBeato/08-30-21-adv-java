public class SimpleThreads {

    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + message);
    }

    private static class MessageLoop implements Runnable {

        @Override
        public void run() {

            String[] importantInfo = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too",
            };

            try {
                for (String info : importantInfo) {
                    Thread.sleep(4000);
                    threadMessage(info);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {


        // Delay in milliseconds
        // before we interrupt the MessageLoop thread

        long patience = 1000 * 60 * 60;

        // if command line arguments are present
        // gives patience in seconds
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer!");
                System.exit(1);
            }
        }

        // code to start my messageloop thread
        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        while(t.isAlive()) {
            threadMessage("Still waiting...");
            // I want to wait for a max of 1 second
            // for the MessageLoop thread to finish
            t.join(3000);
            if (((System.currentTimeMillis() - startTime) > patience)
            & t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // this will wait indefinitely
                t.join();
            }
            threadMessage("Finally!");
        }
    }


}
