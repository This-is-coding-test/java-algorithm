import java.util.*;

class 심사위원 {

    // n명의 심사위원이 점수를 주면 그 중 k개를 골라 제일 큰 점수와 제일 낮은 점수의 차가 10점 이하면 k개 점수의 평균을 해당선수의 최종점수로 결정
    // 여러개면 그 중 k개의 평균점수가 가장 작은 값을 최종점수로 결정
    // 이분탐색?

    // [80, 85, 91, 92, 95, 97, 99]
    public int solution(int[] score, int k) {
        Arrays.sort(score);
        int answer = 0;
        for (int right = k - 1, left = 0; right < score.length; right++) {
            if (score[right] - score[left] <= 10) {
                long sum = 0;
                for(int i = left; i <= right; i++) {
                    sum += score[i];
                }
                answer = (int) (sum / k);
                break;
            }
            left++;
        }
        return answer;
    }

    public static void main(String[] args) {
        심사위원 T = new 심사위원();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
