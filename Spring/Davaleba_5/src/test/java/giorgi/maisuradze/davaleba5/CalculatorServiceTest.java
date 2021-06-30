package giorgi.maisuradze.davaleba5;

import giorgi.maisuradze.davaleba5.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorServiceTest {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorServiceTest(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Test
    void multiplicationTest() {
        int expected = 20;
        int actual;

        actual = calculatorService.multiplication(5, 4);
        assertEquals(expected, actual);
    }
}
