package core.stringbuilder.task.memento;

import java.util.Stack;

public class StringBuilderOriginator {

    private StringBuilder stringBuilder;
    private final Stack<StringBuilderMemento> mementoStack;

    public StringBuilderOriginator(String initialContent) {
        this.stringBuilder = new StringBuilder(initialContent);
        this.mementoStack = new Stack<>();
    }

    public void append(String str) {
        this.mementoStack.push(new StringBuilderMemento(stringBuilder));
        stringBuilder.append(str);
    }

    public void saveState() {
        mementoStack.push(new StringBuilderMemento(stringBuilder));
    }

    public void undo() {
        if (!mementoStack.isEmpty()) {
            stringBuilder = new StringBuilder(mementoStack.pop().getState()); // работает как надо
        }
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
