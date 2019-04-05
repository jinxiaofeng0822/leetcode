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
        StringBuilder sb = new StringBuilder();

        String maxInt = String.valueOf(Integer.MAX_VALUE);
        String minInt = String.valueOf(Integer.MIN_VALUE);
        String strx = String.valueOf(x);
        if (!strx.startsWith("-")) {
            if (strx.length() == maxInt.length()) {
                //需要考虑溢出
                for (int i = strx.length()-1,j=0; i >=0; i--,j++) {
                    if(strx.charAt(i)>maxInt.charAt(j)){
                        return 0;
                    } else if (strx.charAt(i)<maxInt.charAt(j)) {
                        break;
                    }
                }
                for (int i = strx.length()-1; i >=0; i--) {
                    sb.append(strx.charAt(i));
                }
                return Integer.valueOf(sb.toString());
            }else {
                for (int i = strx.length()-1; i >=0; i--) {
                    sb.append(strx.charAt(i));
                }
                return Integer.valueOf(sb.toString());
            }
        }else{
            strx=strx.substring(1);
            if (strx.length() == minInt.length()-1) {
                for (int i = strx.length()-1,j=1; i >=0; i--,j++) {
                    if(strx.charAt(i)>minInt.charAt(j)){
                        return 0;
                    } else if (strx.charAt(i)<minInt.charAt(j)) {
                        break;
                    }
                }
                for (int i = strx.length()-1; i >=0; i--) {
                    sb.append(strx.charAt(i));
                }
                return -Integer.valueOf(sb.toString());
            }else {
                for (int i = strx.length()-1; i >=0; i--) {
                    sb.append(strx.charAt(i));
                }
                return -Integer.valueOf(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        StringProblem sp = new StringProblem();
        System.out.println(Integer.MAX_VALUE);

//        int i = 2147483647;
        int i = -2147483412;

        int r =sp.reverse(i);
        System.out.println(r);

    }
}
