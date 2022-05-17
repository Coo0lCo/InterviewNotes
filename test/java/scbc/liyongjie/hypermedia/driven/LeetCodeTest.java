package scbc.liyongjie.hypermedia.driven;

import org.junit.jupiter.api.Test;
import org.springframework.util.comparator.Comparators;

import java.util.TreeSet;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/4
 */

public class LeetCodeTest {
    @Test
    public void test() {
        TreeSet<Student> treeSet = new TreeSet<>(Comparators.comparable());
    }
    static class Student{
        private String name;
        private Integer age;
    }

    private static class Solution {
        public static void main(String[] args) {

        }
        public String replaceSpace(String s) {
            StringBuilder stringBuilder = new StringBuilder(s);
            for (int i = 0 ; i < stringBuilder.length() ; i++){
                if(stringBuilder.charAt(i) == ' '){
                    stringBuilder.replace(i,i+1,"%20");
                }
            }
            return stringBuilder.toString();
        }
    }
}
