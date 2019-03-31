package array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jin Xiaofeng
 */
public class StringProblem {
    private static final Logger log = LoggerFactory.getLogger(StringProblem.class);

    /**
     * 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     * 示例 1：
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * 示例 2：
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     * @param s
     */
    public void reverseString(char[] s) {
        for (int i = 0,j=s.length-1; i < s.length; i++,j--) {
            if(i>=j){
                break;
            }
            char t=s[i];
            s[i]=s[j];
            s[j]=t;
        }
    }

    public int reverse(int x) {
        return 0;
    }

    public static void main(String[] args) {
        log.info("最大int值：{}",Integer.MAX_VALUE);
        String s = String.valueOf(Integer.MAX_VALUE);
        log.info(s);
//        String m = "2300000000";
        String m = "123";
        int mi=Integer.parseInt(m);
        log.info("{}",mi);
    }
}
