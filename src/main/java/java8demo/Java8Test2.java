package java8demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2018/6/10.
 */
public class Java8Test2 {
    public static void main(String[] args) {
        List<String> names1 = new ArrayList<>();
        names1.add("Runoob");
        names1.add("Google");
        names1.add("TaoBao");
        names1.add("BaiDu");
        names1.add("Sina");
        List<String> names2 = new ArrayList<>();
        names2.add("Google");
        names2.add("TaoBao");
        names2.add("Runoob");
        names2.add("BaiDu");
        names2.add("Sina");
        Java8Test2 test2 = new Java8Test2();
        System.out.println("java7 语法：");
        test2.sortUseringJava7(names1);
        System.out.println(names1);
        System.out.println("java8 语法");
        test2.sortUseringJava8(names2);
        System.out.println(names2);
    }

    private void sortUseringJava8(List<String> names2) {
        Collections.sort(names2,(s1,s2)->s1.compareTo(s2));
    }
    private void sortUseringJava7(List<String> names1) {
        Collections.sort(names1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
