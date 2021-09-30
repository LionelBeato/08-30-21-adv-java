import org.junit.jupiter.api.Test;
import threads.SampleThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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

    @Test
    void parallelTest() {
        List<Long> aList = new ArrayList<>();
        Stream<Long> parallelStream = aList.parallelStream();

        assertTrue(parallelStream.isParallel());
    }

    @Test
    void givenRangeOfLongs_whenSummedInParallel_thenShouldBeEqualToExpectedTotal() throws ExecutionException, InterruptedException {

        long firstNum = 1;
        long lastNum = 1_000_000;

        List<Long> aList = LongStream
                .rangeClosed(firstNum, lastNum)
                .boxed()
                .collect(Collectors.toList());

        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        long actual = customThreadPool
                .submit(() -> aList.parallelStream()
                        .reduce(0L, Long::sum))
                        .get();

        var expected = (lastNum + firstNum) * lastNum / 2;

        assertEquals(expected, actual);
    }



}