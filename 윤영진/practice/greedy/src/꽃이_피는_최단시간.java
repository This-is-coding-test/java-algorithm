import java.util.*;

class 꽃이_피는_최단시간 {
    // 현수는 N개의 꽃씨 종류를 가짐
    // 각 꽃씨는 종류별로 현수가 씨를 심은 기간과 심어진 씨가 성장해서 꽃이 피는 기간
    // 현수는 하루에 하나의 꽃씨만 심을 수 있다.
    // 모든 꽃이 피기까지 걸리는 최단시간
    // 성장기간이 짧은게 뒤로 오도록 배치 -> 내림차순정렬
    // 범위 -> 그리디
    public int solution(int[] plantTime, int[] growTime) {
        int answer = 0;
        int n = plantTime.length;
        int[][] list = new int[n][2];
        for (int i = 0; i < n; i++) {
            list[i][0] = plantTime[i];
            list[i][1] = growTime[i];
        }
        Arrays.sort(list, (o1, o2) -> (o2[1] - o1[1]));

        int start = 0, end;
        for (int i = 0; i < n; i++) {
            end = start + list[i][0] + list[i][1]; // 0 + 1 + 5 / 1 + 4 + 3 / 5 + 2 + 2 / 7 + 3 + 1
            answer = Math.max(answer, end); // 6 -> 8 -> 9 -> 11

            start += list[i][0]; // 0 -> 1 -> 5 -> 7 ->
        }


        return answer;
    }

    public static void main(String[] args) {
        꽃이_피는_최단시간 T = new 꽃이_피는_최단시간();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }
}