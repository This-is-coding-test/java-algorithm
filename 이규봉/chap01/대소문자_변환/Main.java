package chap01.대소문자_변환;

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                stringBuilder.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                stringBuilder.append(Character.toUpperCase(ch));
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Main main = new Main();
        String newStr = main.solution(str);

        System.out.println(newStr);
    }

}
