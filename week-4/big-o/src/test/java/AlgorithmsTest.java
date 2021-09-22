import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    @Test
    void add() {
        int expected = 15;
        int actual = Algorithms.add(5, 10);
        assertEquals(expected, actual);
    }

    @Test
    void constantTime() {
       int[] items = {1, 2, 3, 4, 5};
       Algorithms.printFirstItem(items);
    }

    @Test
    void linearTime() {
        int[] items = {1, 2, 3, 4, 5};
        Algorithms.printAllItems(items);
    }

    @Test
    void quadraticTime() {
        int[] items = {1, 2, 3, 4, 5};
        Algorithms.printAllPossibleOrderedPairs(items);
    }

    @Test
    void factTest() {
        long expected = 120;
        long actual = BaeldungExamples.factorial(5);
        assertEquals(expected, actual);
    }


}