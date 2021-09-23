public class Sorts {

    // quick sort
    // we plug in the array we want sorted,
    // the initial lowest position, and then the highest position
    public static void quickSort(Integer[] arr, int low, int high) {

        // check to see if the array is null or empty
        // returns immediately if the condition is true
        if (arr == null || arr.length == 0) {
            return;
        }

        // checking the "shape" of the array ensuring
        // the subsequent operations are valid
        if (low >= high) {
            return;
        }

        // calculating the middleIndex and thus the pivot value
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // cloned values of low and high so that we can safely
        // swap values later
        int i = low;
        int j = high;

        // enter this loop only if our low is less than or equal to our high
        while (i <= j) {
            // increments our low while the value at that index is less than the pivot
            while (arr[i] < pivot) {
                i++;
            }
            // decrements our high while the value at that index is more than the pivot
            while (arr[j] > pivot) {
                j--;
            }

            // performs the swap if our low is less than or equal to our high
            if (i <= j) {
                swap( arr, i, j);
                i++;
                j--;
            }
        }

        // performs the sort recursively by augmenting
        // the high or low value to be equal to
        // the cloned iterated value of i or j
        // based on a less/greater than condition
        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    // the actual swap method
    // we set up a temp variable to hold the element at x
    // change the element at x to be equal to the element at y
    // and change y to the temp variable, effectly swapping the
    // values in place
    public static void swap (Integer array[], int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // merge sort
    public static Comparable[] mergeSort(Comparable[] list) {

        // if our list is empty, then simply return
        if (list.length <= 1) {
            return list;
        }

        // below we split the array in half
        // using arraycopy we copy the original array
        // values into the two split arrays
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        // sort each half recursively
        mergeSort(first);
        mergeSort(second);

        merge(first, second, list);

        return list;
    }

    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {

        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }

        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }






}
