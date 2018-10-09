import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaBasics {
    public Integer sumToCheck = 100;

    @Test
    public void firstTest() {
        Integer a = 85;
        Integer b = 15;
        Integer sumToCheck = 100;

        Integer c = 45;
        Integer d = 55;

        sumAndCheck(a, b);
        sumAndCheck(c, d);
    }

    private void sumAndCheck(Integer a, Integer b) {
        Integer sum = a + b;
        Assertions.assertEquals(sumToCheck, sum, "Numbers not equal");
    }
}
