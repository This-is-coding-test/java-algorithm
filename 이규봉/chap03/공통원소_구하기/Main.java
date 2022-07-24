package 공통원소_구하기;

import java.util.*;

public class Main {

    public List<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        int p1 = 0, p2 = 0;
        List<Integer> answer = new ArrayList<>();

        // 먼저 정렬해주기
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // 투 포인터 알고리즘
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr1[p1] > arr2[p2]) {
                p2++;
            } else {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        Main main = new Main();
        List<Integer> answer = main.solution(n, m, arr1, arr2);
        answer.forEach(e -> System.out.print(e + " "));
    }

}
