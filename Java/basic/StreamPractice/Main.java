import java.util.stream.*;
import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // createStream();  // 创建stream
        reducePractice();    // reduce 用法
        // fibonacci();    //iterate & map 用法
        // mapPractice();
        // filterPractice();    // filter 用法
        // filterPractice2();   // 用filter过滤出及格的同学
        // output2List();   // output to list
    }

    public static void output2List(){
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> list = stream.filter(s -> s != null && !s.isBlank()).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void filterPractice2(){
        List<Person> persons = List.of(new Person("小明", 88), new Person("小黑", 62), new Person("小白", 45),
				new Person("小黄", 78), new Person("小红", 99), new Person("小林", 58));
		// 请使用filter过滤出及格的同学，然后打印名字:
		persons.stream()
                .filter(x -> x.score>=60)
                .forEach(x -> System.out.println(x.name + ": " + x.score));

        // List<Person> list = persons.stream().collect(Collectors.toList());
        // System.out.println(list);
    }

    public static void filterPractice(){
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> n % 2 != 0)    // filter 单数
                .forEach(System.out::println);

        // 用filter来count
        List<Integer> list = Arrays.asList(7,6,9);
        long count = list.stream().filter(x -> x > 6).count();
        System.out.println(count);
    }

    public static void mapPractice(){
        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ")
                .stream()
                .map(String::trim) // 去首尾空格
                .map(String::toLowerCase) // 变小写
                .forEach(System.out::println); // 打印
    }

    public static void fibonacci() {
        // method 1
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
        .limit(10)
        .map(t -> t[0])
        .forEach(x -> System.out.println(x));

        // method 2
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(10).forEach(System.out::println);
    }

    public static void createStream(){
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        Stream<String> stream1 = Arrays.stream(new String[] { "A", "B", "C" });
        Stream<String> stream2 = List.of("X", "Y", "Z").stream();
        // forEach()方法相当于内部循环调用，
        // 可传入符合Consumer接口的void accept(T t)的方法引用：
        stream.forEach(System.out::println);
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
    }

    public static void reducePractice(){
        // 求和
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(sum); // 45
        // 求积
        int s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(1, (acc, n) -> acc * n);
        System.out.println(s); // 362880
        // 最大
        int max = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce((acc, n) -> acc < n ? n : acc).get();
        System.out.println(max);
    }
}

class NatualSupplier implements Supplier<Integer> {
    int first = 0, second = 1;
    public Integer get() {
        int temp = second;
        second = first + second;
        first = temp;
        return first;
    }
}

class Person {
	String name;
	int score;

	Person(String name, int score) {
		this.name = name;
		this.score = score;
	}
}