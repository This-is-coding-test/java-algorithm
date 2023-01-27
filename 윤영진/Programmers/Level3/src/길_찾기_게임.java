import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 길_찾기_게임 {

    static class Node implements Comparable<Node> {
        int x, y, v;
        Node left, right;

        public Node(int x, int y, int v, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y != o.y) return o.y - this.y;
            else return this.x - o.x;
        }
    }

    static List<Node> nodes = new ArrayList<>();
    static int[][] answer;
    static Node root;
    static int idx = 0;

    public int[][] solution(int[][] nodeinfo) {
        answer = new int[nodeinfo.length][2];
        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            nodes.add(new Node(x, y, i + 1, null, null));
        }

        Collections.sort(nodes);
        root = nodes.get(0);

        for (int i = 1; i < nodes.size(); i++) {
            insertNode(root, nodes.get(i)); // y는 크게, x는 작게 sorting
        }

        preorder(root);
        idx = 0;
        postorder(root);


        return answer;
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[idx++][1] = root.v;
        }

    }

    private void preorder(Node root) {

        if (root != null) {
            answer[idx++][0] = root.v;
            preorder(root.left);
            preorder(root.right);
        }


    }

    private void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
    }
}
