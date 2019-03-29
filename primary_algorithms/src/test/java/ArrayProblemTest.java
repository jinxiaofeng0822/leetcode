import array.ArrayProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Jin Xiaofeng
 */
public class ArrayProblemTest {
    private static ArrayProblem ar = new ArrayProblem();

    @Test
    void moveZeroesTest(){
        int[] a = {1,2,3,4,0,0,8,7,0,7,6,5,4};
        int[] b = {1,2,3,4,8,7,7,6,5,4,0,0,0};

        ar.moveZeroes(a);
        Assertions.assertArrayEquals(b,a);
    }

    @Test
    void twoSumTest(){
        int[] a={2, 7, 11, 15};
        int[] result = ar.twoSum(a, 9);
        Assertions.assertEquals(0,result[0]);
        Assertions.assertEquals(1,result[1]);
    }
}
