package core.stringbuilder.task.decorator;

public class Main {

    public static void main(String[] args) {
        StringBuilderSnapshot sb = new StringBuilderSnapshot("tratata");
        sb.append(" bah");
        sb.append(" bah");
        sb.append(" bah");
        System.out.println(sb);
        System.out.printf(sb.undo().undo().toString());
    }

}
