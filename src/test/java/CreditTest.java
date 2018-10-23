import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditTest {
    @Test
    public void creditSumTest() {
        float checkSum = 1240;
        Integer creditSum = 1000;
        double sum = creditSum + creditSum * 0.1 + creditSum * 0.08 + creditSum * 0.06;
        Assertions.assertEquals(checkSum, sum, "sum not right");
    }
}