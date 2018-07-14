package java8demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Auther:
 * @Date: 2018-07-14 18:42
 * @Description: 勾股数
 */
public class PythagoreanTriple {
    /**
     *  map:将一种类型的值转换为另一种类型的值，比如将List转为Set
     *  flatMap：将多个Stream连接成一个Stream，这时候不是用新值去爱Stream的值，与map有所区别，这是重新生成一个Stream对象取而代之
     *  mapToObj
     *
     * @param args
     */
    public static void main(String[] args) {

        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples.limit(5).forEach(t-> System.out.println(t[0] +", " +t[1] +", " +t[2]));
        testMapAndFlatMap();
    }



    public static void testMapAndFlatMap() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        //将words数组中的元素再按照字符拆分，然后字符去重，最终达到["h", "e", "l", "o", "w", "r", "d"]
        //如果使用map，是达不到直接转化成List<String>的结果
        List<String> stringList = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        stringList.forEach(e -> System.out.println(e));
        words.stream().map(word -> Arrays.stream(word.split(""))).distinct().collect(Collectors.toList()).forEach(e-> System.out.println(e));
    }
}
