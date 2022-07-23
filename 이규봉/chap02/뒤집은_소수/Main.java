package 뒤집은_소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> solution(int[] nums) {
        List<Integer> primeNums = new ArrayList<>();

        for (int x : nums) {
            int num = x;
            int result = 0;

            /* 일의 자리 수 구해서 누적 */
            while (num > 0) {
                int n = num % 10;
                result = result * 10 + n;
                num /= 10;
            }

            if (isPrime(result)) {
                primeNums.add(result);
            }
        }

        return primeNums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Main main = new Main();
        List<Integer> primeNums = main.solution(nums);
        primeNums.forEach(num -> System.out.print(num + " "));
    }

}
