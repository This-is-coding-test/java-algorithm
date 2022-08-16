package 중복_확인;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public char solution(int n, int[] arr) {
        char answer = 'U';

        // 기본형 타입의 배열일 경우 DualPivotQuickSort(두 개의 피벗 사용) 사용 - Worst: O(N^2), Average: O(NlogN), Best: O(NlogN)
        // 레퍼런스 타입일 경우엔 TimSort 사용 - Worst: O(N^2), Average: O(NlogN), Best: O(N)
        // 따라서, 최악의 경우에도 O(NlogN)의 정렬 알고리즘이 필요하다면 기본형보단 레퍼런스 타입의 배열 사용하기
        Arrays.sort(arr);

        for (int i = 0; i < n-1; i++) {
            if (arr[i] == arr[i + 1]) {
                return 'D';
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
        char answer = main.solution(n, arr);
        System.out.println(answer);
    }

}
