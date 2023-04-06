import java.util.*;

class 스프링_쿨러 {
    // 수직선상으로 표현되는 잔디밭에는 스프링 쿨러가 설치
    // 잔디밭의 길이는 0번부터 N번 위치 -> 각 위치에는 스프링쿨러가 N + 1 개 설치
    // 수직선상 범위 -> 그리디?

    public int solution(int n, int[] nums) {
        int answer = 0;
        int[][] lines = new int[n + 1][2];
        for (int i = 0; i < nums.length; i++) {
            lines[i][0] = Math.max(0, i - nums[i]);
            lines[i][1] = Math.min(n, i + nums[i]);
        }
        Arrays.sort(lines, (o1, o2) -> o1[0] - o2[0]);
        int start = 0, end = 0, i = 0;
        while(i < lines.length) {
            while (i < lines.length && lines[i][0] <= start) {
                end = Math.max(end, lines[i][1]);
                i++;
            }
            answer++;
            if(end == n) return answer;
            if(start == end) return -1; // while문을 한 번도 돌지 않은 경우
            start = end;
        }

        return answer;
    }

    public static void main(String[] args) {
        스프링_쿨러 T = new 스프링_쿨러();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}