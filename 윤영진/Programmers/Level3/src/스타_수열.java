import java.util.HashMap;

class 스타_수열 {
    // 교집합 후보군 -> [5 : 2] [3 : 3] [2 : 1]

    public int solution(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>(a.length);
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        int answer = 0;

        for (Integer key : map.keySet()) {
            if (map.get(key) * 2 <= answer) continue;
            int star = 0;
            for (int i = 0; i < a.length - 1; i++) {
                if ((a[i] == key || a[i + 1] == key) && a[i] != a[i + 1]) {
                    star += 2;
                    i++;
                }
            }

            answer = Math.max(answer, star);
        }

        return answer;
    }
}
