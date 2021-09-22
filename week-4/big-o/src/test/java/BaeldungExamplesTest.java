import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaeldungExamplesTest {

    @Test
    void logTime() {
        BaeldungExamples.logTime(800000);
    }

    @Test
    void nLogNTime() {
        BaeldungExamples.nlogNTime(8000);
    }

    @Test
    void quadraticTime() {
        BaeldungExamples.quadraticTime(800);
    }

    @Test
    void expoTime() {
        BaeldungExamples.expoTime(8);
    }

    @Test
    void factTime() {
        BaeldungExamples.factTime(5);
    }
}