import java.security.SecureRandom;

public class Password {

    public static String getPassword(int len, int randNumOrigin, int randNumBound) {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.ints(randNumOrigin, randNumBound + 1)
                .filter(i -> Character.isAlphabetic(i) || Character.isDigit(i))
                .limit(len)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
