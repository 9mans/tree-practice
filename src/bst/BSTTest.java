package bst;

public class BSTTest{

    public static void main(String[] args) {
        BST tree = new BST();

        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);

        System.out.println(tree.search(tree.root, 30));
        System.out.println(tree.search(tree.root, 100));

        System.out.println(tree.findMax(tree.root));
        System.out.println(tree.findMin(tree.root));


    }
}

class Node {
    int value; // 노드에 저장되는 값
    Node left; // 각각 노드의 왼쪽 자식과 오른쪽 자식 노드를 가리키는 참조
    Node right;

    Node(int value) { // 전달받은 value 값을 노드에 저장하는 생성자
        this.value = value; // 초기에 자식이 없기 때문에 left, right 는 null
        left = null;
        right = null;
    }
}

class BST {

    Node root; // 루트노드를 가리키는 참조 초기값 null로 비어있는 상태를 나타낸다

    // BST 삽입
    // 최초 삽입 시에 root는 null이기 때문에 루트를 새로 만들고 값을 추가하면
    // 추가한 value가 새로 만든 루트의 value보다 큰지 작은지를 비교한다
    // 비교 후 해당하는 위치에 노드를 또 추가해준다.
    // root.left = insert(root.left, value)는 Node 타입인 left.value에 값을 추가한다는 의미이다
    // 루트 노드의 왼쪽 노드에 값을 추가한다는 뜻이다
    // 다시 insert 메서드를 호출하고 Node 타입의 root 매개변수에 root.left를 변수로 사용하는 재귀호출
    public Node insert(Node root, int value) {

        if (root == null) { // root가 비어있다면 새로운 노드를 생성한다
            return new Node(value);
        }

        if (value < root.value) { // 삽입하려는 값이 현재 노드보다 작으면 왼쪽 서브트리로 이동한다
            root.left = insert(root.left, value);
        } else if (value > root.value) { // 삽입하려는 값이 현재 노드보다 크면 오른쪽 서브트리로 이동한다
            root.right = insert(root.right, value);
        }

        return root;
    }


    // 특정값 탐색하기
    public boolean search(Node root, int value) {

        if (root == null) { // 트리가 비어 있거나 값이 없는 경우
            return false;
        }

        if (value == root.value) { // 값을 찾았을 때
            return true;
        }

        if (value < root.value) { // 값을 비교하여 왼쪽 혹은 오른쪽 서브트리로 이동 재귀호출
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    // 최대값과 최소값 찾기
    public int findMax(Node root) {

        if (root == null) { // 루트가 비어있을 때 에러 발생
            throw new IllegalArgumentException("tree is empty");
        }

        while (root.right != null) { // root.right가 null일때까지 게속 탐색하여 root를 root.right로 게속 변환
            root = root.right;
        }

        return root.value;
    }

    public int findMin(Node root) {

        if (root == null) {
            throw new IllegalArgumentException("tree is empty");
        }

        while (root.left != null) {
            root = root.left;
        }

        return root.value;
    }

    public Node delete(Node root, int value) {

        if (root == null) {
            return null;
        }

        if (value < root.value) { // 밸류 값과 루트 노드의 값을 비교하여 오른쪽에서 삭제할지 왼쪽에서 삭제할지 결정
            root.left = delete(root.left, value);
        } else if (value > root.value) {
            root.right = delete(root.right, value);

        } else { // 오른쪽 왼쪽을 이동하다 삭제할 값을 찾았을 때
            if (root.left == null) { // 자식이 하나이거나 없을때 (왼쪽이 비어있거나 둘 다 없을때)
               return root.right;
            } else if (root.right == null) { // 자식이 하나이거나 없을때 (오른쪽이 비어있음)
                return root.left;
            }

            // 자식이 둘일 경우
            root.value = findMin(root.right); // 중위 후속자의 값으로 대체
            root.right = delete(root.right, root.value); // 중위 후속자를 삭제
        }
        return root;
    }
}
