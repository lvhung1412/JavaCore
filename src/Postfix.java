import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    private static int priority(char x){
        if(x == '(' ){
            return 0;
        }
        if(x == '+' || x == '-'){
            return 1;
        }
        if(x == '*' || x == '/' || x == '%'){
            return 2;
        }
        return 3;
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
    
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
    
            if( c == ' '){
                continue;
            }
            // số
            else if (Character.isDigit(c)) {
                result.append(c);
    
                // Nếu ký tự tiếp theo không phải số thì thêm khoảng trắng
                if (i + 1 < expression.length() && !Character.isDigit(expression.charAt(i + 1))) {
                    result.append(" ");
                }
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            }
            // toán tử và kiểm tra độ ưu tiên của phép toán
            else {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
            // System.out.println(result);
        }
    
        // Lấy ra các toán tử còn lại trong stack
        while (!stack.isEmpty()) {
            result.append(" "+stack.pop());
        }
    
        return result.toString().trim();
    }
      
    public static int evaluatePostfix(String postfix){
        Stack<Integer> stack = new Stack<>();
        StringBuilder number  = new StringBuilder();
        for(int i = 0; i < postfix.length(); i++){
            char c = postfix.charAt(i);

            // nhiều chữ số
            if (Character.isDigit(c)) {
                number.append(c);
            }

            // Nếu gặp khoảng trắng -> Đưa số vào stack
            else if (c == ' ') {
                if (number.length() > 0) {
                    stack.push(Integer.parseInt(number.toString()));
                    number.setLength(0);
                }
            }
            // toán tử
            else {
                int b = stack.pop();
                int a = stack.pop();

                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': 
                        if (b == 0) throw new ArithmeticException("Lỗi: Chia cho 0!");
                        stack.push(a / b);
                        break;
                    case '%': stack.push(a % b); break;
                }
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập biểu thức trung tố: ");
        String infixExpression = scanner.nextLine();

        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Biểu thức hậu tố: " + postfixExpression);

        int result = evaluatePostfix(postfixExpression);
        System.out.println("Giá trị của biểu thức: " + result);

        scanner.close();
    }
}
