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

	public int RPN(String expression) {

        Stack<Integer> stack = new Stack<>();
        
        String[] tokens = expression.split("\\s+");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? 0 : stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Aplikowanie operatora do dwóch liczb
    private int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                }
			default:
				throw new IllegalArgumentException("Unknown operator: " + operator);
			}
        }

	}
