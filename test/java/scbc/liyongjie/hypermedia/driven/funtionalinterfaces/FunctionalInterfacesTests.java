package scbc.liyongjie.hypermedia.driven.funtionalinterfaces;

import org.junit.jupiter.api.Test;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/11
 */
public class FunctionalInterfacesTests {
    @Test
    public void test(){
        MyFunctionalInterface<String> myFunctionalInterface = index -> {
            String s = String.valueOf(index);
            return s+" ";
        };
        System.out.println(myFunctionalInterface.get(10));
    }
}
