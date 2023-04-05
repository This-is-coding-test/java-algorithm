import java.util.*;

class 교육_과정 {
    // 위상정렬 ?
    // 비순환 방향 그래프에서 정점을 선형으로 정렬하는 것
    // 주로 선후 관계가 있는 일련의 작업을 차례대로 수향하기 위해 순서를 정할 때 사용하는 알고리즘

    ArrayList<ArrayList<Integer>> adjList;
    HashMap<String, Integer> map = new HashMap<>();
    int[] indegree;
    List<Integer> order;
    int n;

    public String[] solution(String[] subjects, String[] course) {
        for (int i = 0; i < subjects.length; i++) {
            map.put(subjects[i], i);
        }
        n = subjects.length;
        adjList = new ArrayList<>();
        indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < course.length; i++) {
            String[] tmp = course[i].split(" ");
            int post = map.get(tmp[0]);
            int prev = map.get(tmp[1]);
            adjList.get(prev).add(post);
            indegree[post]++;
        }

        String[] answer = new String[n];
        order = new ArrayList<>();

        topologySort();

        for (int i = 0; i < n; i++) {
            answer[i] = subjects[order.get(i)];
        }


        return answer;
    }

    private void topologySort() {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            order.add(curr);

            for (Integer next : adjList.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }

    }

    public static void main(String[] args) {
        교육_과정 T = new 교육_과정();
        System.out.println(Arrays.toString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
    }
}