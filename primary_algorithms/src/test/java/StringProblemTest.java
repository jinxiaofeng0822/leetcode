import array.StringProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Jin Xiaofeng
 */
public class StringProblemTest {
    private static final Logger log = LoggerFactory.getLogger(StringProblemTest.class);
    private StringProblem sp = new StringProblem();

    @Test
    void reverseStringTest() {
        char[] c = {'a', 'b', 'c', 'd', 'e','f'};
        char[] ex = {'f', 'e', 'd', 'c', 'b','a'};
        sp.reverseString(c);
        log.info("翻转过后的数组为：{}", Arrays.toString(c));
        Assertions.assertArrayEquals(ex,c);
    }
}
