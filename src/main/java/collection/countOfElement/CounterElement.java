package collection.countOfElement;

import java.util.HashMap;
import java.util.Map;

public class CounterElement {
    public static <T> Map<T, Integer> countOfElements(T[] array) {
        Map<T, Integer> counterMap = new HashMap<T, Integer>();
        for (T element : array) {
            counterMap.put(element, counterMap.getOrDefault(element, 0) + 1);
        }
        return counterMap;
    }
}
