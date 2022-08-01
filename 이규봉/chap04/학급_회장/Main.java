package 학급_회장;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public char solution(int n, String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        char answer = ' ';
        for (char key : hashMap.keySet()) {
            if (hashMap.get(key) > max) {
                max = hashMap.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String str = scanner.next();

        Main main = new Main();
        char answer = main.solution(n, str);
        System.out.println(answer);
    }

}
