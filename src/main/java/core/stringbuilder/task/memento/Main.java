package core.stringbuilder.task.memento;

public class Main {

    public static void main(String[] args) {
        StringBuilderOriginator originator = new StringBuilderOriginator("Строка инициализации");

        System.out.println(originator);


        originator.append(" - Первая строка");
        originator.saveState();
        System.out.println(originator);


        originator.append(" - Вторая строка");
        originator.saveState();
        System.out.println(originator);

        originator.append(" - Третья строка");
        System.out.println(originator);

        originator.undo();
        System.out.println("После undo:\n" + originator);

        originator.undo();
        System.out.println("После второго undo:\n" + originator);

        originator.undo();
        System.out.println("После 3 undo:\n" + originator);

    }
}
