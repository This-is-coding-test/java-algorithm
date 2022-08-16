package 장난꾸러기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        // 깊은 복사(객체의 실제 값을 새로운 객체로 복사) ex. Arrays.copyOf(), a.clone(), System.arraycopy()
        // <-> 얕은 복사(객체의 주소 값만 복사) ex. int[] b = a;
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);

        for (int i = 0; i < n; i++) {
            if (arr[i] != sortedArr[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Main main = new Main();
        List<Integer> answer = main.solution(n, arr);
        answer.forEach(e -> System.out.print(e + " "));
    }

}
