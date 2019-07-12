package com.yinwq.chunting.study.jdk1_8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * @Author: yinwenqiang@qccr.com
 * @Date: Created in 2019/1/25 14:57
 */
public class lambda {

    public static void main(String[] args) {

        //thread();
        //listSort();
        //singleParam();
        //passVariable();
        //stream();
        //reduce();
        //reduce2();
        //count();

        find();
    }

    /**
     * – 搜索相关
     * – allMatch：是不是Stream中的所有元素都满足给定的匹配条件
     * – anyMatch：Stream中是否存在任何一个元素满足匹配条件
     * – findFirst: 返回Stream中的第一个元素，如果Stream为空，返回空Optional
     * – noneMatch：是不是Stream中的所有元素都不满足给定的匹配条件
     * – max和min：使用给定的比较器（Operator），返回Stream中的最大|最小值
     *
     */
    private static void find() {
        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(ints.stream().allMatch(item -> item < 100));
        ints.stream().max((o1, o2) -> o1.compareTo(o2)).ifPresent(System.out::println);
    }

    private static void count() {
        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("ints sum is:" + ints.stream().count());
    }

    private static void reduce2() {
        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("ints sum is:" + ints.stream().reduce(0, (sum, item) -> sum + item));
    }

    private static void reduce() {
        List<Integer> ints = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());
    }

    private static void stream() {
        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        List<Integer> collect = nums.stream().filter(num -> num != null).distinct().collect(Collectors.toList());
        List<Integer> collect1 = nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).boxed().collect(Collectors.toList());
        List<Integer> collect2 = nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).boxed().collect(Collectors.toList());
        List<Integer> collect3 = nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).boxed().collect(Collectors.toList());
        System.out.println("sum is:"+nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());
    }

    public static void thread() {
        Thread thread = new Thread(() -> System.out.println("hello lambda!"));
        thread.start();
    }

    public static void listSort() {
        List<String> list = Lists.newArrayList("a", "c", "b");
        Collections.sort(list, (str1, str2) -> str1.compareTo(str2));

        //方法引用和构造器引用
        list.forEach(System.err::println);
    }

    /**
     * 单参数语法
     */
    public static void singleParam(){
        List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> lowercaseNames = proNames.stream().map(name -> {return name.toLowerCase();}).collect(Collectors.toList());
        lowercaseNames.forEach(System.err::println);
    }

    /**
     * 单语句写法
     * 当lambda表达式只包含一条语句时，可以省略大括号、return和语句结尾的分号
     */
    public static void singleStatement(){
        List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> lowercaseNames = proNames.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());
        lowercaseNames.forEach(System.err::println);
    }

    /**
     * 方法引用写法
     * 当lambda表达式只包含一条语句时，可以省略大括号、return和语句结尾的分号
     */
    public static void methodRef(){
        List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> lowercaseNames = proNames.stream().map(String::toLowerCase).collect(Collectors.toList());
        lowercaseNames.forEach(System.err::println);
    }

    /**
     * lambda传递变量
     * 变量waibu ：外部变量
     * 变量chuandi ：传递变量
     * 变量zidingyi ：内部自定义变量
     *
     * lambda表达式可以访问给它传递的变量，访问自己内部定义的变量，同时也能访问它外部的变量。
     * 不过lambda表达式访问外部变量有一个非常重要的限制：变量不可变（只是引用不可变，而不是真正的不可变）。
     * 当在表达式内部修改waibu = waibu + " ";时，IDE就会提示你：
     * Local variable waibu defined in an enclosing scope must be final or effectively final
     * 编译时会报错。因为变量waibu被lambda表达式引用，所以编译器会隐式的把其当成final来处理。
     * 以前Java的匿名内部类在访问外部变量的时候，外部变量必须用final修饰。现在java8对这个限制做了优化，可以不用显示使用final修饰，但是编译器隐式当成final来处理。
     *
     */
    public static void passVariable(){
        //将为列表中的字符串添加前缀字符串
        String waibu = "lambda :";
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(chuandi -> {
            Long zidingyi = System.currentTimeMillis();
            return waibu + chuandi + " -----:" + zidingyi;
        }).collect(Collectors.toList());
        execStrs.forEach(System.err::println);

    }

}
