import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Tree_말단_노드까지의_가장_짧은_경로_BFS {


    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = null;
            rt = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static Node root;
    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.lt.lt = new Node(7);
        root.lt.lt.lt = new Node(8);
        root.lt.lt.rt = new Node(9);
        root.lt.rt.lt = new Node(10);
        root.lt.rt.rt = new Node(11);

        queue.offer(root);
        BFS();

    }

    private static void BFS() {
        int L = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if (node.lt == null && node.rt == null) {
                    System.out.println(L);
                    return;
                }
                if (node.lt != null) queue.offer(node.lt);
                if (node.rt != null) queue.offer(node.rt);


            }
            L++;

        }

    }

}
