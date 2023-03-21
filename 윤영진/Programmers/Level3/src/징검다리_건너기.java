import java.util.*;

class 징검다리_건너기 {

    // 징검다리는 일렬로 놓여 있고 각 징검다리의 디딤돌에는 모두 숫자가 적혀 있으며 디딤돌의 숫자는 한 번 밟을 때마다 1씩 줄어든다.
    // 디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없으며 이때는 그 다음 디딤돌로 한번에 여러 칸을 건너 뛸 수 있다.
    // 단, 다음으로 밟을 수 있는 디딤돌이 여러 개인 경우 무조건 가장 가까운 디딤돌로 건너뛴다. 

    // 디딤돌에 적힌 숫자가 순서대로 담긴 배열 stones와 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수 k가 매개변수로 주어질 때, 최대 몇명까지 징검다리를 건널 수 있는지 return

    static int K;
    static int answer = 0;

    public int solution(int[] stones, int k) {
        K = k;
        binarySearch(stones);
        return answer;
    }

    public void binarySearch(int[] stones) {

        int left = 0;
        int right = 200000000;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(canCross(stones, mid)) {
                left = mid + 1;
                answer = mid;
            }else {
                right = mid - 1;
            }
        }
    }

    public boolean canCross(int[] stones, int friends) {
        int cnt = 0;
        for(int i = 0; i < stones.length; i++) {

            if (stones[i] - friends < 0) cnt++;
            else cnt = 0;

            if(cnt == K) return false;

        }
        return true;
    }

}