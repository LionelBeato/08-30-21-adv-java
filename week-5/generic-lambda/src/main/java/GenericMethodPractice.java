import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericMethodPractice {

    // below we are using a generic to denote
    // the element type for our input array
    // note that we also use it for our enhanced for loop
    public static <T> void printArray (T[] arrayIn) {
        for( T element: arrayIn) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // below we are utilizing bounded types
    // the only way the logic below will work is if we
    // ensure T is also of type Comparable
    // We can do this by extending, defining an upper bounded
    public static <T extends Comparable<T>> int greaterThan(T[] numArray, T elem) {
        int count = 0;
        for (T element : numArray) {
            if (element.compareTo(elem) > 0) {
                ++count;
            }
        }
            return count;
    }

    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    // let's say we have an array of integers that
    // we want to transform into a list of strings
    public static <T, G> List<G> fromArrayToListTG(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

    public static <T extends Number> List<T> fromNumArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    // Note that we can use multiple bounds
    // if one is a class, that has to go first in our generic
    public static <T extends Number & Comparable<T>> List<T> fromMultipleArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

//    public static void paintAllBuildings(List<Building> buildings) {
//        buildings.forEach(Building::paint);
//    }

    // if we want to use the above method with any subtype of Building
    // we need to employ a wildcard that extends Building
    public static void paintAllBuildings(List<? extends Building> buildings) {
        buildings.forEach(Building::paint);
    }

    // note that you can perform the inverse of extends by using "super"
    // this means that our unknown type needs to be a super type to
    // Integer or whatever type you declare
    // you can refer to this as a lower bound
//    <? super Integer>

    // below we have an example of how generic methods are transformed
    // at compile time, exemplifying type erasure. Your generic will
    // typically be replaced by Object if it is unbounded. If it is bounded,
    // it will be replaced by the upper bound.
    public <T> List<T> genericMethod(List<T> list) {
        return list.stream().collect(Collectors.toList());
    }

    // for illustration
    public List<Object> withErasure(List<Object> list) {
        return list.stream().collect(Collectors.toList());
    }



}
