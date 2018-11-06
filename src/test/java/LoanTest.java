import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoanTest {
    public Integer loanSum = 1000;
    public Integer finalSum = 1240;
    private static final Logger LOGGER = LogManager.getLogger(LoanTest.class);

    @Test
    public void loanSumTest() {
        LOGGER.info("Wa are calculate loan sum");
        Integer sum = loanSum + loanSum / 100 * 10 + loanSum / 100 * 8 + loanSum / 100 * 6;

        LOGGER.info("We are checking loan sum with our calculation");
        Assertions.assertEquals(finalSum, sum, "Sum not correct");
    }
}