package core.stringbuilder.task.memento;

public class StringBuilderMemento {
    private final String state;

    public StringBuilderMemento(StringBuilder stringBuilder) {
        this.state = stringBuilder.toString();
    }

    public String getState() {
        return state;
    }
}
