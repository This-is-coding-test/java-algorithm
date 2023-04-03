import java.util.*;

class 카드_가져가기_2 {
    // 한 라운드에 1개의 카드를 각각 가져갑니다.
    // 총합이 게임의 점수이고 점수가 큰 사람이 이기는 게임입니다.

    // 현수는 Lady first 정신에 따라 매 라운드 영희가 먼저 카드를 가져가낟.
    // 대신 현수는 k번의 우선권을 가진다.
    // 현수가 게임에서 얻을 수 있는 최대 점수를 반환하는 프로그램 작성
    // 현수와 영희는 게임을 이기기 위해 최선을 다한다.
    // 내림차순 정렬
    // [12, 12, 8, 7, 5, 3, 3, 1, 1, 1]
    // [[12 - 12], [8 - 7], [5 - 3], [3 - 1], [1 - 1]]
    // [0, 1, 2, 2, 1] -> 3, 4라운드에 k를 사용하는게 이득
    // [(2, 3) (2, 4) (1, 2) (1, 5), (0, 1)]

    public int solution(int[] nums, int k) {
        int answer = 0;
        Integer[] sortedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedNums, Collections.reverseOrder());

        Integer[] diff = new Integer[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            answer += sortedNums[i * 2 + 1];
            diff[i] = sortedNums[i * 2] - sortedNums[i * 2 + 1];
        }
        Arrays.sort(diff, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            answer += diff[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        카드_가져가기_2 T = new 카드_가져가기_2();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}