import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class 방의_개수 {
    class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public int solution(int[] arrows) {
        int answer = 0;
        Node curr = new Node(0, 0);
        Map<Node, ArrayList<Node>> map = new HashMap<>();

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) {
                Node next = new Node(curr.x + dx[arrow], curr.y + dy[arrow]);

                if (!map.containsKey(next)) {
                    map.put(next, new ArrayList<>());
                    map.get(next).add(curr);

                    map.putIfAbsent(curr, new ArrayList<>());
                    map.get(curr).add(next);

                }
                // 재방문 && 첫 간선
                else if (!map.get(curr).contains(next)) {
                    map.get(curr).add(next);
                    map.get(next).add(curr);
                    answer++;
                }

                curr = next;
            }
        }

        return answer;
    }
}