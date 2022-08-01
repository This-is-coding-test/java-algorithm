package 교육과정_설계;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public String solution(String str1, String str2) {
        Queue<Character> q = new LinkedList<>();

        for (char c : str1.toCharArray()) {
            q.offer(c);
        }

        for (char c : str2.toCharArray()) {
            if (q.contains(c)) {
                if (q.poll() != c) {
                    return "NO";
                }
            }
        }

        return q.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        Main main = new Main();
        String answer = main.solution(str1, str2);
        System.out.println(answer);
    }

}
