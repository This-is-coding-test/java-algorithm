package 이진트리_순회;

// 전위 순회: 부모 노드 -> 왼쪽 노드 -> 오른쪽 노드
// 중위 순회: 왼쪽 노드 -> 부모 노드 -> 오른쪽 노드
// 후위 순회: 왼쪽 노드 -> 오른쪽 노드 -> 부모 노드 (병합 정렬에 사용됨)

class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main {

    Node root;

    public void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            /* 전위 순회 */
//            System.out.println(root.data + " ");
            DFS(root.lt);
            /* 중위 순회 */
//            System.out.println(root.data + " ");
            DFS(root.rt);
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
}

}
