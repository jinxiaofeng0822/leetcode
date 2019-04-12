package array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

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
     * <p>
     * 示例 1：
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * <p>
     * 示例 2：
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     * @param s
     */
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < s.length; i++, j--) {
            if (i >= j) {
                break;
            }
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     * 示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     * @param x
     * @return
     */
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();

        String maxInt = String.valueOf(Integer.MAX_VALUE);
        String minInt = String.valueOf(Integer.MIN_VALUE);
        String strx = String.valueOf(x);
        if (!strx.startsWith("-")) {
            if (strx.length() == maxInt.length()) {
                //需要考虑溢出
                for (int i = strx.length() - 1, j = 0; i >= 0; i--, j++) {
                    if (strx.charAt(i) > maxInt.charAt(j)) {
                        return 0;
                    } else if (strx.charAt(i) < maxInt.charAt(j)) {
                        break;
                    }
                }
                for (int i = strx.length() - 1; i >= 0; i--) {
                    sb.append(strx.charAt(i));
                }
                return Integer.valueOf(sb.toString());
            } else {
                for (int i = strx.length() - 1; i >= 0; i--) {
                    sb.append(strx.charAt(i));
                }
                return Integer.valueOf(sb.toString());
            }
        } else {
            strx = strx.substring(1);
            if (strx.length() == minInt.length() - 1) {
                for (int i = strx.length() - 1, j = 1; i >= 0; i--, j++) {
                    if (strx.charAt(i) > minInt.charAt(j)) {
                        return 0;
                    } else if (strx.charAt(i) < minInt.charAt(j)) {
                        break;
                    }
                }
                for (int i = strx.length() - 1; i >= 0; i--) {
                    sb.append(strx.charAt(i));
                }
                return -Integer.valueOf(sb.toString());
            } else {
                for (int i = strx.length() - 1; i >= 0; i--) {
                    sb.append(strx.charAt(i));
                }
                return -Integer.valueOf(sb.toString());
            }
        }
    }


    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 案例:
     * s = "leetcode"
     * 返回 0.
     *
     * s = "loveleetcode",
     * 返回 2.
     *
     * 注意事项：您可以假定该字符串只包含小写字母。
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        char[] c = s.toCharArray();
        Map<String,Integer> map = new HashMap<>(c.length);
        for (int i = 0; i < c.length; i++) {
            String str = String.valueOf(c[i]);
            map.put(str,map.getOrDefault(str,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for (String s1 :map.keySet()) {
            if(map.get(s1)==1){
                list.add(s.indexOf(s1));
            }
        }
        Collections.sort(list);
        return list.size()>0?list.get(0):-1;
    }

    /**
     * 有效的字母异位词
     *
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     *
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if(sc.length!=tc.length){
            return false;
        }
        Arrays.sort(sc);
        Arrays.sort(tc);
        for (int i = 0; i < sc.length; i++) {
            if(sc[i]!=tc[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 验证回文字符串
     *
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s.length()<=1){
            return true;
        }

        int count = 0;
        char[] c = new char[s.length()];

        s=s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp>='a'&&temp<='z'||temp>='0'&&temp<='9'){
                c[count]=temp;
                count++;
            }
        }

        if(count<=1){
            return true;
        }
        for (int i = 0; i <= count/2; i++) {
            if(c[i]!=c[count-i-1]){
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串转换整数 (atoi)
     *
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续
     * 数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的
     * 数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，
     * 它们对于函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅
     * 包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     *
     * 说明：
     *
     * 假设我们的环境只能存储 32 位大小的有符号整数，
     * 那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，
     * 请返回INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *
     * 示例 1:
     * 输入: "42"
     * 输出: 42
     *
     * 示例 2:
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     *
     * 示例 3:
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     *
     * 示例 4:
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     *
     * 示例 5:
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if(str==null){
            return 0;
        }
        str=str.trim();
        if(str.length()==0){
            return 0;
        }


        if(str.length()==1&&str.charAt(0)>=48&&str.charAt(0)<=57){
            return Integer.valueOf(str);
        }

        String maxInt = String.valueOf(Integer.MAX_VALUE);
        String minInt = String.valueOf(Integer.MIN_VALUE);

        StringBuilder sb = new StringBuilder();
        boolean checkNum=true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(i==0){
                if (c=='-'||(c>=48&&c<=57)) {
                    sb.append(c);
                    if(c>=49&&c<=57){
                        checkNum=false;
                    }
                }else if(c=='+'){
                    continue;
                }else{
                    return 0;
                }
            }else if(c=='0'&&checkNum){
                continue;
            }else{
                if (c >= 48 && c <= 57) {
                    sb.append(c);
                    checkNum=false;
                }else{
                    break;
                }
            }
        }

        if (sb.length()==0){
            return 0;
        }else if(sb.length()==1&&sb.charAt(0)=='-'){
            return 0;
        }

        boolean positive = true;
        if(sb.charAt(0)=='-'){
            positive=false;
        }

        if (positive) {
            if(sb.length()>maxInt.length()){
                return Integer.MAX_VALUE;
            }else if(sb.length()==maxInt.length()){
                //需要考虑溢出
                for (int i = 0; i <sb.length(); i++) {
                    if (sb.charAt(i) > maxInt.charAt(i)) {
                        return Integer.MAX_VALUE;
                    }else if(sb.charAt(i) < maxInt.charAt(i)){
                        break;
                    }
                }
                return Integer.valueOf(sb.toString());
            }else{
                return Integer.valueOf(sb.toString());
            }
        }else{
            if(sb.length()>minInt.length()){
                return Integer.MIN_VALUE;
            }else if(sb.length()==minInt.length()){
                //需要考虑溢出
                for (int i = 0; i <sb.length(); i++) {
                    if (sb.charAt(i) > minInt.charAt(i)) {
                        return Integer.MIN_VALUE;
                    }else if(sb.charAt(i) < minInt.charAt(i)){
                        break;
                    }
                }
                return Integer.valueOf(sb.toString());
            }else{
                return Integer.valueOf(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        int a = '0';
        int z = '9';
        System.out.println(a);
        System.out.println(z);
        System.out.println(122-97);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
