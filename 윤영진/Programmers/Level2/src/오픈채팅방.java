import java.util.*;

public class 오픈채팅방 {
    // 채팅방에서 닉네임을 변경하는 방법은 두 가지
    // 1. 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
    // 2. 채팅방에서 닉네임을 변경한다.

    // 닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경

    static class Pair {
        String id;
        String type; // in or out

        public Pair(String id, String type) {
            this.id = id;
            this.type = type;
        }
    }

    static Map<String, String> map = new HashMap<>(); // 최종 (id, nickname)
    static List<Pair> results = new ArrayList<>();
    public String[] solution(String[] record) {
        String[] answer;

        for (String r : record) {
            String[] tmp = r.split(" ");
            if (tmp.length == 3) { // Change or Enter
                String type = tmp[0];
                String id = tmp[1];
                String nickname = tmp[2];

                if (type.equals("Change")) {
                    map.put(id, nickname);
                } else { // Enter
                    map.put(id, nickname);
                    results.add(new Pair(id, type));
                }
            } else { // Leave
                String type = tmp[0];
                String id = tmp[1];
                results.add(new Pair(id, type));
            }
        }

        answer = new String[results.size()];


        for (int i = 0; i < results.size(); i++) {
            Pair p = results.get(i);
            String nickname = map.get(p.id);
            if (p.type.equals("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";
            } else {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }


        return answer;
    }
}
