package collection.countOfElement;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5,6,7,8,9,11,11,43,4,5,5,5,6};
        Map<Integer, Integer> intCountMap = CounterElement.countOfElements(intArray);
        System.out.println(intCountMap);

        String[] strings = {"Синий", "Белый", "Желтый","Красный", "Зеленый", "Белый", "Белый", "Желтый", "Красный"};
        Map<String, Integer> mapCountStrings = CounterElement.countOfElements(strings);
        System.out.println(mapCountStrings);
    }
}
