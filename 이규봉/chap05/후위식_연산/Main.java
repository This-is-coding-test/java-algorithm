package 후위식_연산;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        int lt, rt;

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                rt = stack.pop();
                lt = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(lt + rt);
                        break;
                    case '-':
                        stack.push(lt - rt);
                        break;
                    case '*':
                        stack.push(lt * rt);
                        break;
                    case '/':
                        stack.push(lt / rt);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Main main = new Main();
        int answer = main.solution(str);
        System.out.println(answer);
    }

}
