import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Buffered {

    public static void main(String[] args) throws FileNotFoundException {

        // bufferedReader is similar to FileReader
        // take note that for its constructor, you need to give it an
        // instance of FileReader
        BufferedReader reader = new BufferedReader(new FileReader("input"));


    }

}
