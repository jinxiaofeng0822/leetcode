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

    @Test
    void reverseTest(){
        int x = 1234;
        int y = sp.reverse(x);
        Assertions.assertEquals(4321,y);
    }

    @Test
    void firstUniqCharTest(){
        String s = "leetcode";
        int i = sp.firstUniqChar(s);
        Assertions.assertEquals(0,i);
    }

    @Test
    void isAnagramTest(){
        String s = "anagram", t = "nagaram";
        boolean result = sp.isAnagram(s,t);
        Assertions.assertEquals(true,result);
    }

    @Test
    void isPalindrome(){
        String s = "0P";
        boolean result = sp.isPalindrome(s);
        Assertions.assertEquals(false,result);
    }

    @Test
    void myAtoi(){
        String s = "2147483648";
        int i = sp.myAtoi(s);
        Assertions.assertEquals(2147483647,i);

        String s2 = "1";
        int i2 = sp.myAtoi(s2);
        Assertions.assertEquals(1,i2);

        String s3 = "-2147483649";
        int i3 = sp.myAtoi(s3);
        Assertions.assertEquals(-2147483648,i3);

    }

    @Test
    void longestCommonPrefix(){
        String[] str = {"abc","abc","abc"};
        String result = sp.longestCommonPrefix(str);
        Assertions.assertEquals("abc",result);

        String[] str2 = {"abddd","ab123213","ab456456"};
        String result2 = sp.longestCommonPrefix(str2);
        Assertions.assertEquals("ab",result2);

        String[] str3 = {"abc","abc",""};
        String result3 = sp.longestCommonPrefix(str3);
        Assertions.assertEquals("",result3);
    }
}
