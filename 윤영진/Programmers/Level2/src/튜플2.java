import java.util.*;

class 튜플2 {
    // 1. 중복된 원소 O
    // 2. 원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플
    // 3. 튜플의 원소 개수는 유한

    // 원소의 개수가 n이고 중복되는 원소가 없는 튜플이 주어질 때
    public int[] solution(String s) {
        s = s.substring(2);
        s = s.substring(0, s.length() - 2).replace("},{", "-");

        String[] split = s.split("-");
        Arrays.sort(split, Comparator.comparingInt(String::length));

        Map<Integer, Integer> map = new HashMap<>();
        for (String s1 : split) {
            String[] tmp = s1.split(",");
            for (int i = 0; i < tmp.length; i++) {
                int num = Integer.parseInt(tmp[i]);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int size = map.size();
        int[] answer = new int[size];

        for (Integer key : map.keySet()) {
            answer[size - map.get(key)] = key;
        }

        return answer;
    }

}
