package collection.filter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"one", "two", "three", "four", "five"};
        StringFilter stringFilter = new StringFilter();
        String[] filteredString = filter(strings, stringFilter);
        for (String string : filteredString) {
            System.out.println(string);
        }
    }

    public static <T> T[] filter(T[] array, Filter<T> filter) {
        T[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            result[i] = filter.apply(array[i]);
        }
        return result;
    }
}
