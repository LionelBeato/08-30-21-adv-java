import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericClassTest {


    @Test
    void myTypeTest() {
        // below we are initializing instances of GenericClass
        // note that we don't have to declare the generic one
        // the righthand side of our declaration
//        List<Boolean> booleanList = new ArrayList<>();
        GenericClass<Boolean> booleanGenericClass = new GenericClass<>();
        GenericClass<String> stringGenericClass = new GenericClass<>();

        booleanGenericClass.add(true);
        stringGenericClass.add("this is my string!");

        System.out.println(booleanGenericClass.myType);
        System.out.println(stringGenericClass.myType);

    }


}