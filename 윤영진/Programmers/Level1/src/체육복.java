import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < reserve.length; i++) {
            set.add(reserve[i]); // 1 3 5
        }
        Arrays.sort(lost);

        ArrayList<Integer> lostList = new ArrayList<>();
        for (int i = 0; i < lost.length; i++) {
            int num = lost[i];

            if (set.contains(num)) set.remove(num);
            else lostList.add(num);
        }

        for (int i = 0; i < lostList.size(); i++) {
            int num = lostList.get(i); // 2

            if (set.contains(num - 1)) set.remove(num - 1);
            else if (set.contains(num + 1)) set.remove(num + 1);
            else answer--;
        }


        return answer;
    }
}
