package stream.task2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import java.util.concurrent.ConcurrentMap;

import java.util.stream.Collectors;

public class ParallelStreamCollectMapAdvancedExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        //Необходимо создать Map которой будет предмет и среднее значение по успеваемости. Нужно использовать patallelStream.
        ConcurrentMap<String, Double> collect = students.stream()
                .parallel()
                .flatMap(s -> s.getGrades().entrySet().stream())
                .collect(Collectors.groupingByConcurrent(
                        Map.Entry<String, Integer>::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)
                            )
                        );

        System.out.println(collect);

    }
}
