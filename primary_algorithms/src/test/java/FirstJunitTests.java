import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jin Xiaofeng
 */
public class FirstJunitTests {
    @Test
    void myFirstTest(){
        assertEquals(2,1+1);
    }

    @Test
    void myFirstTest2(){
        assertEquals(2,0+2);
    }

    @Test
    void myFirstTest3(){
        assertEquals(2,-1+3);
    }
}
