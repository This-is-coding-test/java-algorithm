package 소수;

import java.util.Scanner;

public class Main {

    public int solution(int n) {
        int count = 0;

        /* 시간 초과 */
//        for (int i = 2; i < n; i++) {
//            boolean isPrime = true;
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime) {
//                count++;
//            }
//        }

        /* 에라토스테네스 체 */
        // n번 인덱스를 포함하기 위하여 n + 1로 초기화
        int[] nums = new int[n + 1];

        for (int i = 2; i < n; i++) {
            if (nums[i] == 0) {
                count++;
                // j += i 로 배수 체크
                for (int j = i; j <= n; j += i) {
                    nums[j]++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Main main = new Main();
        int result = main.solution(n);
        System.out.println(result);
    }

}
