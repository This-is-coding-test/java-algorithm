package 암호;

import java.util.Scanner;

public class Main {

    public String solution(int n, String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String subStr = str.substring(0, 7);
            subStr = subStr.replace("#", "1").replace("*", "0");
            char c = (char) Integer.parseInt(subStr, 2);
            sb.append(c);

            str = str.substring(7);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();

        Main main = new Main();
        String result = main.solution(n, str);
        System.out.println(result);
    }

}
