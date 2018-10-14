import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoanTest {
    public Integer loanSum = 1000;
    public Integer finalSum = 1240;

    @Test
    public void loanSumTest() {
        Integer sum = loanSum + loanSum / 100 * 10 + loanSum / 100 * 8 + loanSum / 100 * 6;
        Assertions.assertEquals(finalSum, sum, "Sum not correct");

    }

}
