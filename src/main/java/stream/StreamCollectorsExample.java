package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        //Составляем списки заказов сгруппированные по продукту и их стоимости
        Map<String, List<Double>> groupProductCost = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct, Collectors.mapping(Order::getCost, Collectors.toList())));
        System.out.println("Составляем списки заказов сгруппированные по продукту и их стоимости");
        System.out.println(groupProductCost);
        System.out.println(" ");


        //группировка по товару и общая его стоимость каждого продукта
        Map<String, Double> totalCostOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct, Collectors.summingDouble(Order::getCost)));
        System.out.println("Группировка по товару и общая его стоимость");
        System.out.println(totalCostOrders);
        System.out.println(" ");

        // Сортируем продукты по убыванию общей стоимости
        List<Map.Entry<String, Double>> sortedCostProductDesc = totalCostOrders.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .toList();
        System.out.println("Сортируем продукты по убыванию общей стоимости");
        System.out.println(sortedCostProductDesc);
        System.out.println(" ");


        // Выбираем три самых дорогих продукта
        List<Map.Entry<String, Double>> top3Product = totalCostOrders.entrySet().stream()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Выбираем три самых дорогих продукта");
        System.out.println(top3Product);
        System.out.println(" ");

        // Вычисляем общую стоимость трех самых дорогих продуктов
        double totalCostTop3Product = top3Product.stream()
                .mapToDouble(Map.Entry::getValue)
                .sum();
        System.out.println("Вычисляем общую стоимость трех самых дорогих продуктов");
        System.out.println(totalCostTop3Product);

    }
}
