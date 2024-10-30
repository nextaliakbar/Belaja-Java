package programmer.zaman.now.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import programmer.zaman.now.test.resolver.RandomParamaterResolver;

@Extensions({
        @ExtendWith(RandomParamaterResolver.class)
})
public class AbstrackCalculatorTest {
    public Calculator calculator = new Calculator();

    @BeforeEach
    public void setup() {
        System.out.println("Before Each");
    }
}
