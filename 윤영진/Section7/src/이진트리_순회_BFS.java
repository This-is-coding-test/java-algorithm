import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class 이진트리_순회_BFS {

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
    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {


        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        queue.offer(root);
        BFS();

    }

    public static void BFS() {

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                System.out.print(node.data + " ");

                if (node.lt != null) {
                    queue.offer(node.lt);
                }
                if (node.rt != null) {
                    queue.offer(node.rt);
                }
            }
        }

//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            System.out.print(node.data + " ");
//            if (node.lt != null) {
//                queue.offer(node.lt);
//            }
//            if (node.rt != null) {
//                queue.offer(node.rt);
//            }
//
//        }

    }


}
