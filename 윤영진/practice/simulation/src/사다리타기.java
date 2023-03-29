import java.util.*;
class 사다리타기 {
    // 현수네 반에는 n명의 학생
    // n명의 학생을 모두 사다리타기를 한 다음 당첨된 학생을 이번주 학급회장
    //
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        int[] members = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            members[i] = i;
        }

        for (int i = 0; i < ladder.length; i++) {
            for (int m : ladder[i]) { // 1, 3 -> (1 <-> 2) (3 <-> 4)
                int tmp = members[m]; // 1
                members[m] = members[m + 1];
                members[m + 1] = tmp;
            }
        }
        for (int i = 1; i <= n; i++) {
            answer[i - 1] = (char)(64 + members[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        사다리타기 T = new 사다리타기();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}}))); // 1, 2 3, 4 / 2, 3 4, 5 / 1, 2 4, 5
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}