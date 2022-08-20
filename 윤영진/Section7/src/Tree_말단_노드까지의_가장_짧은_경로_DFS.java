import java.io.IOException;

public class Tree_말단_노드까지의_가장_짧은_경로_DFS {

    // 최단 거리 문제이므로 DFS가 아닌 BFS로 푸는 것이 정답에 더 가깝다.
    // DFS로 문제를 풀 경우 완전이진트리가 아닌 경우 구하기 힘들다.
    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = null;
            rt = null;
        }
    }

    public static Node root;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
//        root.rt.lt = new Node(6);

        int dfs = DFS(root, 0);
        System.out.println(dfs);

    }

    private static int DFS(Node root, int level) {

        if (root.lt == null && root.rt == null) {
            return level;
        } else {
            return Math.min(DFS(root.lt, level + 1), DFS(root.rt, level + 1));
        }
    }


}
