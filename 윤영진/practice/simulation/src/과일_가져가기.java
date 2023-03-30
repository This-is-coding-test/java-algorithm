import java.util.*;

class 과일_가져가기 {
    // 모든 학생의 책상에는 사과, 배, 귤이 담긴 A, B, C 세 바구니
    // A - 사과, B - 배, C - 귤
    // 각 학생은 책상에 있는 세 바구니 중 하나를 가질 수 있다. 단 이 세바구니 중 가장 적게 과일이 담겨있는 바구니를 가질 수 있다.

    // 모든 학생은 딱 한 번 바구니의 과일 한 개를 다른 학생과 교환할 수 있는 기회가 있다.

    public int solution(int[][] fruit) {
        int n = fruit.length;
        boolean[] visited = new boolean[n];
        // 1. Unique?
        // 2. 최소값이 서로 다른지
        // 3. 교환 후에도 최소?

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int idx1 = isUnique(fruit[i]);
            if (idx1 != -1) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[j]) continue;
                    int idx2 = isUnique(fruit[j]);
                    if (idx2 != -1 && idx1 != idx2) {
                        if (fruit[i][idx1] + 1 <= fruit[i][idx2] - 1 && fruit[j][idx1] - 1 >= fruit[j][idx2] + 1) {
                            fruit[i][idx1] += 1;
                            fruit[i][idx2] -= 1;

                            fruit[j][idx1] -= 1;
                            fruit[j][idx2] += 1;
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int apple = fruit[i][0];
            int pear = fruit[i][1];
            int mandarin = fruit[i][2];

            int min = Math.min(apple, pear);
            min = Math.min(min, mandarin);

            answer += min;
        }

        return answer;
    }

    private int isUnique(int[] fruit) {

        int apple = fruit[0];
        int pear = fruit[1];
        int mandarin = fruit[2];

        if (apple == pear || apple == mandarin || pear == mandarin) return -1;

        int min = Math.min(apple, pear);
        min = Math.min(min, mandarin);

        for (int i = 0; i < fruit.length; i++) {
            if (min == fruit[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        과일_가져가기 T = new 과일_가져가기();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}