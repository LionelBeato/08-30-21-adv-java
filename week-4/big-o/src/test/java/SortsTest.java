import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {

    Integer[] arr;
    int[] toSort;
    int[] sortedInts;
    int[] sortedRangeInts;

    @BeforeEach
    void setUp() {
        arr = new Integer[]{12, 13, 24, 10, 4, 6, 90};

        toSort = new int[]{5,1,89,255,7,88,200,123,66};
        sortedInts = new int[]{1, 5, 7, 66, 88, 89, 123, 200, 255};
        sortedRangeInts = new int[]{5, 1, 89, 7, 88, 200, 255, 123, 66};
    }

    @Test
    void givenIntArray_whenUsingSort_thenSortedArray() {
        Arrays.sort(toSort);
        assertArrayEquals(toSort, sortedInts);
    }

    @Test
    void giveIntArray_whenUsingRangedSort_thenRangeSortedArray() {
        Arrays.sort(toSort, 3, 7);
        assertArrayEquals(toSort, sortedRangeInts);
    }

    @Test
    void givenList_whenUsingSort_thenSortedList() {
        List<Integer> toSortList = Arrays.asList(5,1,89,255,7,88,200,123,66);
        List<Integer> sortedList = Arrays.asList(1, 5, 7, 66, 88, 89, 123, 200, 255);

        Collections.sort(toSortList);
        assertArrayEquals(toSortList.toArray(), sortedList.toArray());
    }



    @Test
    void quickSort() {

        // below is our unsorted array
        // here we invoke the quickSort method to sort the array above
        Sorts.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    void mergeSort() {
        Sorts.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}