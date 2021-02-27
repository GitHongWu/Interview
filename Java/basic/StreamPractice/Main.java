import java.util.stream.*;
import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // createStream();  // ����stream
        reducePractice();    // reduce �÷�
        // fibonacci();    //iterate & map �÷�
        // mapPractice();
        // filterPractice();    // filter �÷�
        // filterPractice2();   // ��filter���˳������ͬѧ
        // output2List();   // output to list
    }

    public static void output2List(){
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> list = stream.filter(s -> s != null && !s.isBlank()).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void filterPractice2(){
        List<Person> persons = List.of(new Person("С��", 88), new Person("С��", 62), new Person("С��", 45),
				new Person("С��", 78), new Person("С��", 99), new Person("С��", 58));
		// ��ʹ��filter���˳������ͬѧ��Ȼ���ӡ����:
		persons.stream()
                .filter(x -> x.score>=60)
                .forEach(x -> System.out.println(x.name + ": " + x.score));

        // List<Person> list = persons.stream().collect(Collectors.toList());
        // System.out.println(list);
    }

    public static void filterPractice(){
        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> n % 2 != 0)    // filter ����
                .forEach(System.out::println);

        // ��filter��count
        List<Integer> list = Arrays.asList(7,6,9);
        long count = list.stream().filter(x -> x > 6).count();
        System.out.println(count);
    }

    public static void mapPractice(){
        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ")
                .stream()
                .map(String::trim) // ȥ��β�ո�
                .map(String::toLowerCase) // ��Сд
                .forEach(System.out::println); // ��ӡ
    }

    public static void fibonacci() {
        // method 1
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
        .limit(10)
        .map(t -> t[0])
        .forEach(x -> System.out.println(x));

        // method 2
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // ע�⣺�������б����ȱ�����������ٴ�ӡ:
        natual.limit(10).forEach(System.out::println);
    }

    public static void createStream(){
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        Stream<String> stream1 = Arrays.stream(new String[] { "A", "B", "C" });
        Stream<String> stream2 = List.of("X", "Y", "Z").stream();
        // forEach()�����൱���ڲ�ѭ�����ã�
        // �ɴ������Consumer�ӿڵ�void accept(T t)�ķ������ã�
        stream.forEach(System.out::println);
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
    }

    public static void reducePractice(){
        // ���
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(sum); // 45
        // ���
        int s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(1, (acc, n) -> acc * n);
        System.out.println(s); // 362880
        // ���
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