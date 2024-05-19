package collection.filter;

public class StringFilter implements Filter<String> {
    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }
}
