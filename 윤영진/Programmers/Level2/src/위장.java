import java.util.*;
class 위장 {
    HashMap<String, Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 1;

        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        for (String key : map.keySet()) {
            Integer num = map.get(key);
            answer *= (num + 1);
        }

        return answer - 1;
    }

}
