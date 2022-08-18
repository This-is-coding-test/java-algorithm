import java.io.IOException;

public class 이진트리_순회 {

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = null;
            rt = null;
        }
    }

    // 전위 순회, 중위순회, 후위순회 공부해두기
    // 전위순회: 부모 -> 왼쪽 -> 오른쪽
    // 중위순회: 왼쪽 -> 부모 -> 오른쪽
    // 후위순회: 왼쪽 -> 오른쪽 -> 부모

    public static Node root;

    public static void main(String[] args) throws IOException {

        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        DFS(root);

    }

    public static void DFS(Node root) {

        if (root == null) {
            return;
        }else {
            // 전위순회
            System.out.print(root.data + " ");
            DFS(root.lt);

            // 중위순회
//            System.out.print(root.data + " ");
            DFS(root.rt);

            // 후위순회
//            System.out.print(root.data + " ");


        }




    }


}
