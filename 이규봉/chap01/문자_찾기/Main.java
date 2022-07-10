package chap01.문자_찾기;

import java.util.Scanner;

public class Main {

    public int solution(String str, char ch) {
        int count = 0;

        for (char c : str.toLowerCase().toCharArray()) {
            if (c == Character.toLowerCase(ch)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char ch = scanner.next().charAt(0);

        Main main = new Main();
        int result = main.solution(str, ch);

        System.out.println(result);
    }

}
