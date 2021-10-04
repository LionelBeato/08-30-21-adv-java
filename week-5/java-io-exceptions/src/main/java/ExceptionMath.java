public class ExceptionMath {

    private static int divide(int x, int y) {
        return x / y;
    }

    // here we are taking a programmatic approach to
    // general "error" handling
    // this is a more proactive and idiomatic way of doing this
    private static int divideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    // here we accept the philosophy
    // of asking for forgiveness vs permission
    // this is not considered as idiomatic as LBYL
    // but is just as valid
    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }


    public static void main(String[] args) {

        int x = 100;
        int y = 0;

        // this method will throw an exception!
//        System.out.println(divide(x, y));
        System.out.println(divideLBYL(x, y));
        System.out.println(divideEAFP(x, y));

    }

}
