import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송아지_찾기 {

    static class Node {
        int data;
        이진트리_순회_BFS.Node lt, rt;

        public Node(int val) {
            data = val;
            lt = null;
            rt = null;
        }
    }

    static int S;
    static int E;
    static int[] check = new int[10001];
    static int[] moves = {1, -1, 5};
    public static Queue<Node> queue = new LinkedList<>();

    public static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        root = new Node(5);

        queue.offer(root);
        BFS();
    }

    private static void BFS() {

        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {

            }

            for (int move : moves) {
                queue.offer(move);

            }

        }

    }
}
