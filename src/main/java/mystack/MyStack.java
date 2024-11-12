package mystack;

import java.util.*;

public class MyStack {
    private List<String> elements = new ArrayList<>();

    public void push(String element) {
        elements.add(element);
    }

    public String pop() {
        if (!elements.isEmpty()) {
            return elements.remove(elements.size() - 1);
        }
        return null;
    }

    public int size() {
        return elements.size();
    }

    public String peek() {
        if (!elements.isEmpty()) {
            return elements.get(elements.size() - 1);
        }
        return null;
    }
}
