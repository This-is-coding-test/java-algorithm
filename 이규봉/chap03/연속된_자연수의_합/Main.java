package 연속된_자연수의_합;

import java.util.Scanner;

public class Main {

    public int solution(int n) {
        int count = 0;
        int sum = 0;
        int left = 1;

        // 연속된 자연수이므로 중간까지만 돌려도 됨
        int half = n / 2 + 1;
        for (int right = 1; right <= half; right++) {
            sum += right;
            if (sum == n) {
                count++;
            }
            while (sum >= n) {
                sum -= left;
                left++;
                if (sum == n) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Main main = new Main();
        int answer = main.solution(n);
        System.out.println(answer);
    }

}
