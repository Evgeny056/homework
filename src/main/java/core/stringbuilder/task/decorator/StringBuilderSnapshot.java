package core.stringbuilder.task.decorator;

import java.util.Stack;

public class StringBuilderSnapshot {
    private Stack<String> version;
    private StringBuilder stringBuilder;

    public StringBuilderSnapshot() {
        stringBuilder = new StringBuilder();
        version = new Stack<>();
    }

    public StringBuilderSnapshot(int capacity) {
        stringBuilder = new StringBuilder(capacity);
        version = new Stack<>();
    }

    public StringBuilderSnapshot(String s) {
        stringBuilder = new StringBuilder(s);
        version = new Stack<>();
    }

    public StringBuilderSnapshot(CharSequence seq) {
        stringBuilder = new StringBuilder(seq);
        version = new Stack<>();
    }

    public int compareTo(StringBuilder another) {
        version.push(another.toString());
        return stringBuilder.compareTo(another);
    }

    public StringBuilderSnapshot append(Object obj) {
        saveState();
        return append(String.valueOf(obj));
    }

    public StringBuilderSnapshot append(StringBuffer sb) {
        saveState();
        stringBuilder.append(sb);
        return this;
    }

    StringBuilderSnapshot append(String s) {
        saveState();
        stringBuilder.append(s);
        return this;
    }

    public StringBuilderSnapshot append(CharSequence s) {
        saveState();
        stringBuilder.append(s);
        return this;
    }

    public StringBuilderSnapshot append(CharSequence s, int start, int end) {
        saveState();
        stringBuilder.append(s, start, end);
        return this;
    }

    public StringBuilderSnapshot append(char[] str) {
        saveState();
        stringBuilder.append(str);
        return this;
    }

    public StringBuilderSnapshot append(char[] str, int offset, int len) {
        saveState();
        stringBuilder.append(str, offset, len);
        return this;
    }

    public StringBuilderSnapshot append (boolean b) {
        saveState();
        stringBuilder.append(b);
        return this;
    }

    public StringBuilderSnapshot append(char c) {
        saveState();
        stringBuilder.append(c);
        return this;
    }

    public StringBuilderSnapshot append(int i) {
        saveState();
        stringBuilder.append(i);
        return this;
    }

    public StringBuilderSnapshot append(long lng) {
        saveState();
        stringBuilder.append(lng);
        return this;
    }


    public StringBuilderSnapshot append(float f) {
        saveState();
        stringBuilder.append(f);
        return this;
    }


    public StringBuilderSnapshot append(double d) {
        saveState();
        stringBuilder.append(d);
        return this;
    }

    public StringBuilderSnapshot appendCodePoint(int codePoint) {
        saveState();
        stringBuilder.appendCodePoint(codePoint);
        return this;
    }

    public StringBuilderSnapshot delete(int start, int end) {
        saveState();
        stringBuilder.delete(start, end);
        return this;
    }

    public StringBuilderSnapshot deleteCharAt(int index) {
        saveState();
        stringBuilder.deleteCharAt(index);
        return this;
    }

    public StringBuilderSnapshot replace(int start, int end, String str) {
        saveState();
        stringBuilder.replace(start, end, str);
        return this;
    }

    public StringBuilderSnapshot insert(int index, char[] str, int offset,
                                int len)
    {
        saveState();
        stringBuilder.insert(index, str, offset, len);
        return this;
    }

    public StringBuilderSnapshot insert(int offset, Object obj) {
        saveState();
        stringBuilder.insert(offset, obj);
        return this;
    }

    public StringBuilderSnapshot insert(int offset, String str) {
        saveState();
        stringBuilder.insert(offset, str);
        return this;
    }

    public StringBuilderSnapshot insert(int offset, char[] str) {
        saveState();
        stringBuilder.insert(offset, str);
        return this;
    }


    public StringBuilderSnapshot insert(int dstOffset, CharSequence s) {
        saveState();
        stringBuilder.insert(dstOffset, s);
        return this;
    }

    public StringBuilderSnapshot insert(int dstOffset, CharSequence s,
                                int start, int end)
    {
        saveState();
        stringBuilder.insert(dstOffset, s, start, end);
        return this;
    }

    public StringBuilderSnapshot insert(int offset, boolean b) {
        saveState();
        stringBuilder.insert(offset, b);
        return this;
    }


    public StringBuilderSnapshot insert(int offset, char c) {
        saveState();
        stringBuilder.insert(offset, c);
        return this;
    }


    public StringBuilderSnapshot insert(int offset, int i) {
        saveState();
        stringBuilder.insert(offset, i);
        return this;
    }

    public StringBuilderSnapshot insert(int offset, long l) {
        saveState();
        stringBuilder.insert(offset, l);
        return this;
    }


    public StringBuilderSnapshot insert(int offset, float f) {
        saveState();
        stringBuilder.insert(offset, f);
        return this;
    }


    public StringBuilderSnapshot insert(int offset, double d) {
        saveState();
        stringBuilder.insert(offset, d);
        return this;
    }

    private void saveState() {
        version.push(stringBuilder.toString());
    }


    StringBuilderSnapshot undo() {
        if (!version.isEmpty()) {
            stringBuilder = new StringBuilder(version.pop());
        }
        return this;
    }

    public String toString() {
        return stringBuilder.toString();

    }
}

