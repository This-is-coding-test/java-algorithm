import java.util.*;

public class 기능개발 {

    // 기능 개선 작업을 수행 중
    // 각 기능은 진도가 100%일 때 서비스에 반영

    // 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remain = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int r = 100 - progresses[i];
            if (r % speeds[i] == 0) {
                remain[i] = r / speeds[i];
            } else {
                remain[i] = (r / speeds[i]) + 1;
            }
        }

        List<Integer> results = new ArrayList<>();

        int prev = remain[0];
        int cnt = 1;
        for (int i = 1; i < progresses.length; i++) {
            if (prev >= remain[i]) {
                cnt++;
            } else {
                results.add(cnt);
                prev = remain[i];
                cnt = 1;
            }
        }
        results.add(cnt);

        int[] answer = new int[results.size()];

        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }

        return answer;
    }
}
