import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    @Test
    void helloWorldTest() {
        String greeting = "Hello world!";
        // below is an assertion method
        // This will check to see if two values are equal or not
        // causing the test to fail or pass accordingly
        assertEquals("Hello world!", greeting);
    }

    @Test
    void otherHelloWorldTest() {
        var expected = "Hello world!";
        var actual = HelloWorld.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    void customHelloTest() {
        var expected = "Hello, Josh!";
        var actual = HelloWorld.getCustomMessage("Josh");

        assertEquals(expected, actual);
    }

    @Test
    void otherCustomHelloTest() {
        var expected = "Hello, Amanda!";
        var actual = HelloWorld.getCustomMessage("Amanda");

        assertEquals(expected, actual);
    }





}
