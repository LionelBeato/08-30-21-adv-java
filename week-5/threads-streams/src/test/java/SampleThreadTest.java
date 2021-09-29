import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleThreadTest {

    @Test
    void givenStartedThread_whenJoinCalled_waitsTillCompletion() throws InterruptedException {
        Thread t2 = new SampleThread(1);
        t2.start();
        System.out.println("Invoking join");
        t2.join();
        System.out.println("Returned from join");
        assertFalse(t2.isAlive());
    }

    @Test
    void test() throws InterruptedException {
        Thread t1 = new SampleThread(0);
        t1.join();
    }

}