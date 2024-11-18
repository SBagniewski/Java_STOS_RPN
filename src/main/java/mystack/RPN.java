package mystack;

public class RPN {
    public int ev_RPN(String expression) {
        MyStack stack = new MyStack();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int result = applyOperator(a, b, token);
                stack.push(String.valueOf(result));
            } else {
                try {
                    Integer.parseInt(token); 
                    stack.push(token); 
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Niepoprawny znak: " + token);
                }
            }
        }
        return stack.size() == 0 ? 0 : Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

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
                } else {
                    throw new ArithmeticException("Dzielenie przez 0");
                }
            default:
                throw new IllegalArgumentException("Zły operator: " + operator);
        }
    }
}
