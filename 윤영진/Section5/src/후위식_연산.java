import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위식_연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < st.length(); i++) {

            if (Character.isDigit(st.charAt(i))) {
                stack.push(Integer.parseInt(String.valueOf(st.charAt(i))));
            }else {
                Integer a = stack.pop();
                Integer b = stack.pop();
                Integer result = calculate(b, a, st.charAt(i));
                stack.push(result);
            }
        }
        System.out.println(stack.pop());

    }

    private static Integer calculate(Integer a, Integer b, char mark) {

        switch (mark) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;

        }
        return 0;

    }
}
