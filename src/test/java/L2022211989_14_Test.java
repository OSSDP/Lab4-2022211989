import org.example.Solution;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class L2022211989_14_Test {
    /**
     * 等价类划分原则：使用长度边界进行划分，在边界上进行测试
     * 1.边界：12位最长合法IP：
     * 测试"192192192192"
     * 2.边界：4位最短合法IP：
     * 测试“1111“
     * 3.长度为4-12位中间的合法IP：
     * 测试”101023”
     * 4.测试位数小于4位的非法IP：
     * 测试“111”
     * 5.测试位数大于12的非法IP
     * 测试“1111111111111”
     * 6.测试含有非数字的非法IP
     * 测试“123*123”
     */
    String teststr;
    List<String> testmsg = new ArrayList<>();
    /**
     * 最长合法IP
     * 用例192192192192
     */
    @Test
    public void test1() {
        Solution solution = new Solution();
        teststr = "192192192192";
        Collections.addAll(testmsg, "192.192.192.192");
        List<String> stringList = solution.restoreIpAddresses(teststr);
        assertTrue("%s 这是合法IP", stringList.equals(testmsg));
    }

    /**
     * 最短合法IP
     * 用例1111
     */
    @Test
    public void test2() {
        Solution solution = new Solution();
        teststr = "1111";
        Collections.addAll(testmsg, "1.1.1.1");
        List<String> stringList = solution.restoreIpAddresses(teststr);
        assertTrue("%s 这是合法IP", stringList.equals(testmsg));
    }

    /**
     * 4-12位合法IP
     * 用例101023
     */
    @Test
    public void test3() {
        Solution solution = new Solution();
        teststr = "101023";
        Collections.addAll(testmsg, "1.0.10.23", "1.0.102.3", "10.1.0.23","10.10.2.3","101.0.2.3");
        List<String> stringList = solution.restoreIpAddresses(teststr);
        assertTrue("%s 这是合法IP", stringList.equals(testmsg));
    }

    /**
     * 位数少非法IP
     * 用例111
     */
    @Test
    public void test4() {
        Solution solution = new Solution();
        teststr = "111";
        List<String> stringList = solution.restoreIpAddresses(teststr);
        assertTrue("%s 这是非法IP", stringList.equals(testmsg));
    }

    /**
     * 位数多非法IP
     * 用例1111111111111
     */
    @Test
    public void test5() {
        Solution solution = new Solution();
        teststr = "1111111111111";
        List<String> stringList = solution.restoreIpAddresses(teststr);
        assertTrue("%s 这是非法IP", stringList.equals(testmsg));
    }

    /**
     * 含有不是数字的非法IP
     * 用例123*123
     */
    @Test
    public void test6() {
        Solution solution = new Solution();
        teststr = "123*123";
        List<String> stringList = solution.restoreIpAddresses(teststr);
        assertFalse("%s 这是非法IP", stringList.equals(testmsg));
    }
}
