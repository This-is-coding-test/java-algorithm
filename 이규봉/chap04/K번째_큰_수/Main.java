package K번째_큰_수;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public int solution(int n, int k, int[] arr) {
        // 중복 제거 및 정렬도 지원해주는 TreeSet 사용
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for (int e : set) {
            cnt++;
            if (cnt == k) {
                return e;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }


        Main main = new Main();
        int answer = main.solution(n, k, arr);
        System.out.println(answer);
    }

}
