import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericMethodPracticeTest {

    @Test
    void printArray() {

        Integer[] intArray = {10, 20, 30, 40, 50};
        GenericMethodPractice.printArray(intArray);
        String[] stringArray = {"Java", "Ruby", "Python", "Swift", "Rust", "Kotlin"};
        GenericMethodPractice.printArray(stringArray);
        Character[] charArray = {'H', 'E', 'L', 'L', '0'};
        GenericMethodPractice.printArray(charArray);

    }

    @Test
    void listTest() {

        List<Integer> integers = List.of(1,2,3,4,5);

        // below we are instantiating a list
        // using a raw list type
        // this may cause issues related to types
        // later on and ensures no type safety
        List list = new LinkedList();
        list.add(new Integer(1));
        Integer i = (Integer) list.iterator().next();

        // it is better and cleaner to simply
        // utilize a generic so that we can avoid casting
        List<Integer> integerList = new LinkedList<>();


    }

    @Test
    void fromArrayToListTG() {

        Integer[] intArray = {1,2,3,4,5};
        List<String> stringList =
                GenericMethodPractice
                        .fromArrayToListTG(intArray, integer -> integer.toString());

        assertEquals(stringList, List.of("1", "2", "3", "4", "5"));
    }

    @Test
    void fromNumArrayToList() {

        // String is not a subclass of Number
        // thus, we get an error if we attempt to pass it
        // into the method below
        String[] stringArray = {"hello", "world"};
        Float[] floatArray = {3.0f, 4.0f};
//        GenericMethodPractice.fromNumArrayToList(stringArray);
        // since Float is of type Number,
        // we can use it with the bounded type in our method below
        GenericMethodPractice.fromNumArrayToList(floatArray);


    }

    @Test
    void paintAllBuildings() {

        List<House> houses = List.of(new House(), new House());
//        GenericMethodPractice.paintAllBuildings(houses);


    }

    @Test
    void primitiveTest() {

        // below is an illegal use of generics
        // we cannot use primitives for our list
        // because the helper methods will resolve
        // their generics to type Object

//        List<int> list = new ArrayList<>();
//        list.add(14);

        // the way to address this is by utilizing
        // a wrapper class due to the ability to
        // autobox our values
        List<Integer> list = new ArrayList<>();
        list.add(14);

        // the compiled code will look something like this:
        List compiledList = new ArrayList<>();
        list.add(Integer.valueOf(17));
        int first = ((Integer) list.get(0)).intValue();

    }
}