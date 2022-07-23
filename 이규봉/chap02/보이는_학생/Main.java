package 보이는_학생;

import java.util.Scanner;

public class Main {

    public int solution(int[] students) {
        /* 이중 for문 - 안 좋은 방법 */
//        int count = 1;
//
//        for (int i = 1; i < students.length; i++) {
//            boolean isVisible = true;
//            for (int j = 0; j < i; j++) {
//                if (students[i] <= students[j]) {
//                    isVisible = false;
//                    break;
//                }
//            }
//            if (isVisible) {
//                count++;
//            }
//        }

        /* max 사용 */
        int count = 1;
        int maxHeight = students[0];

        for (int i = 1; i < students.length; i++) {
            if (students[i] > maxHeight) {
                count++;
                maxHeight = students[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] students = new int[n];

        for (int i = 0; i < n; i++) {
            students[i] = scanner.nextInt();
        }

        Main main = new Main();
        int count = main.solution(students);

        System.out.println(count);
    }

}
